import pandas as pd
import plotly.graph_objs as go
import plotly.express as px
import pickle
import numpy as np
import yfinance as yf
from sklearn.preprocessing import MinMaxScaler
from sklearn.metrics import mean_squared_error, mean_absolute_error, explained_variance_score, r2_score
from sklearn.metrics import mean_poisson_deviance, mean_gamma_deviance, accuracy_score
from sklearn.ensemble import RandomForestRegressor
from sklearn.svm import SVR
import firebase_admin
from firebase_admin import credentials
import warnings
warnings.filterwarnings("ignore")


# cred = credentials.Certificate("key.json")
# firebase_admin.initialize_app(cred)


def crypt_data(coin, start_date, end_date):
    cryptData = yf.download(coin, start=start_date, end=end_date, group_by="ticker")
    return cryptData


def trainModelForStock(coin='AAPL', start_date="1990-01-01", end_date="2022-12-31",
                       models=RandomForestRegressor(random_state=0), type_model='ml'):
    try:
        # Get Data
        data = crypt_data(coin, start_date, end_date)

        # Fill Empty Data by interpolation
        data = data.fillna(method='ffill')

        # Split Data
        x = data.drop(['Close'], axis=1).values
        y = data.Close

        scalery = MinMaxScaler(feature_range=(0, 1))
        y = scalery.fit_transform(np.array(y).reshape(-1, 1))

        model_name1 = coin + "_scalery.sav"
        pickle.dump(scalery, open(model_name1, 'wb'))

        if type_model == 'ml':
            # Train Model
            models.fit(x, y.ravel())
            print("Model Trained")
            model_name = coin + "_Model.sav"
            pickle.dump(models, open(model_name, 'wb'))
        return models

    except:
        print("Error Occurred, check Inputs and train again.")
        return None


def predictionModel(coin_stock, model, prediction_start_date, prediction_end_date,scmodely):
    p_data = crypt_data(coin_stock, prediction_start_date, prediction_end_date)
    true = p_data['Close']
    p_data = p_data.drop('Close', axis=1)
    pred = model.predict(p_data)
    data_pred = pred.reshape(-1, 1)
    data_pred = scmodely.inverse_transform(data_pred)
    p_data['Close'] = data_pred

    year_data = price_per_year(p_data, coin_stock)
    six_data = price_per_six_month(p_data, coin_stock)
    return year_data, six_data, p_data


def price_per_year(data, coin):
    years = list(data.index.year.unique())
    df_year = pd.DataFrame()

    for year in years:
        year_open = data.loc[data.index.year == year, 'Open'][0]
        year_close = data.loc[data.index.year == year, 'Close'][-1]
        year_low = data.loc[data.index.year == year, 'Low'].min()
        year_high = data.loc[data.index.year == year, 'High'].max()

        df_year[year] = pd.Series([year_open, year_close, year_low, year_high])

    df_year = df_year.T
    df_year = df_year.set_axis(['open', 'close', 'low', 'high'], axis=1)

    # Calculate % change between the open and close price of the year
    df_year['Year Change'] = 100 * (df_year['close'] - df_year['open']) / df_year['open']


    annotations_list = []
    max_high = df_year['high'].max()

    for year in years:
        df_aux = df_year.loc[df_year.index == year]
        loc_x = pd.to_datetime(df_aux.index[0], format='%Y')
        loc_y = df_aux['high'].values[0] / max_high + 0.05
        text = '{:.1f}%'.format(df_aux['Year Change'].values[0])

        annotation = dict(x=loc_x, y=loc_y,
                          xref='x', yref='paper',
                          showarrow=False, xanchor='center',
                          text=text)

        annotations_list.append(annotation)

    # Interactive candlestick chart with Plotly
    candlestick = go.Candlestick(
        x=pd.to_datetime(df_year.index, format='%Y'),
        open=df_year.open,
        close=df_year.close,
        low=df_year.low,
        high=df_year.high
    )

    fig = go.Figure(data=[candlestick])

    fig.update_layout(
        autosize=False,
        width=500,
        height=300,
        title=dict(text=coin + '/USD yearly chart', font=dict(size=18)),
        yaxis_title=dict(text='Price (USD)', font=dict(size=13)),
        margin=dict(l=0, r=20, t=55, b=20),
        xaxis_rangeslider_visible=False,
        annotations=annotations_list,
        paper_bgcolor='rgba(0, 0, 0, 0)'

    )
    fig.show()

    return df_year


def price_per_six_month(data, coin):
    data['Date'] = pd.to_datetime(data.index)
    data['Month'] = data.Date.dt.month
    years = list(data.index.year.unique())
    months = list(data.Month.unique())
    df_month = pd.DataFrame()
    try:
        for year in years:
            months_open = data.loc[(data.index.year == year) & (data.Month == 6), 'Open'][0]
            months_close = data.loc[(data.index.year == year) & (data.Month == 6), 'Close'][-1]
            months_low = data.loc[(data.index.year == year) & (data.Month == 6), 'Low'].min()
            months_high = data.loc[(data.index.year == year) & (data.Month == 6), 'High'].max()

            df_month[year] = pd.Series([months_open, months_close, months_low, months_high])

        df_month = df_month.T
        df_month = df_month.set_axis(['open', 'close', 'low', 'high'], axis=1)

        # Calculate % change between the open and close price of the 6th month
        df_month['Sixth Month Change'] = 100 * (df_month['close'] - df_month['open']) / df_month['open']


        return df_month

    except Exception as e:
        print(e)
        return 0


# Train Model Configuration
coin_list = ["BTC-USD", "ETH-USD", "GOOG", "TSLA", "AAPL", "MSFT", "AMZN"]
for coin_stock in coin_list:
    print("Training Coin", coin_stock)
    model = SVR(kernel='rbf', C=1e2, gamma=0.1)
    start_date = '1990-01-01'
    type_model = 'ml'
    print(trainModelForStock.__doc__)
    model_train = trainModelForStock(coin=coin_stock, start_date=start_date, models=model, type_model=type_model)

# Prediction Configuration

prediction_start_date = '2021-01-01'
prediction_end_date = '2022-01-01'

model_list = ["BTC-USD_Model.sav", "ETH-USD_Model.sav", "GOOG_Model.sav", "TSLA_Model.sav", "AAPL_Model.sav", "MSFT_Model.sav", "AMZN_Model.sav"]
scaler_list = ["BTC-USD_scalery.sav", "ETH-USD_scalery.sav", "GOOG_scalery.sav", "TSLA_scalery.sav", "AAPL_scalery.sav", "MSFT_scalery.sav", "AMZN_scalery.sav"]

for i in range(len(model_list)):
    model = pickle.load(open(model_list[i], 'rb'))
    scy = pickle.load(open(scaler_list[i], 'rb'))

    print(predictionModel.__doc__)
    print("Prediction for Model", model_list[i])
    year, sixth, prediction = predictionModel(coin_stock, model, prediction_start_date, prediction_end_date, scy)
    print(year)
    print(sixth)
    print(prediction)
