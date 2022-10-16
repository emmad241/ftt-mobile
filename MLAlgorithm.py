import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
import yfinance as yf
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import precision_score


sp500 = yf.Ticker("^GSPC")
sp500 = sp500.history(period="max")

plot = sp500.plot.line(y="Close", use_index=True)
del sp500["Dividends"]
del sp500["Stock Splits"]
# print(plot)

sp500["Tomorrow"] = sp500["Close"].shift(-1)
sp500["Target"] = (sp500["Tomorrow"] > sp500["Close"]).astype(int)  # when tomorrow price > previous price, target = 1
sp500 = sp500.loc["1990-01-01":].copy()  # only seeing 1990 onwards, for accuracy
# print(sp500)

model = RandomForestClassifier(n_estimators=100, min_samples_split=100, random_state=1)
train = sp500.iloc[:-100]
test = sp500.iloc[-100:]
predictors = ["Close", "Volume", "Open", "High", "Low"]
model.fit(train[predictors], train["Target"])
predictions = model.predict(test[predictors])
predictions = pd.Series(predictions, index=test.index)
precision_score(test["Target"], predictions)  # % accuracy
combined = pd.concat([test["Target"], predictions], axis=1)
combined.plot()

def predict(train, test, predictors, model):
    model.fit(train[predictors], train["Target"])
    predictions = model.predict(test[predictors])
    predictions = pd.Series(predictions, index=test.index, name="Predictions")
    combined = pd.concat([test["Target"], predictions], axis=1)
    return combined

def backtest(data, model, predictors, start=2500, step=250):  # trading year = 250 days, 2500 = 10 years data
    all_predictions = []                                      # idea is to take the first 10 years data and predict the 11th year, then take the 11 years and predict the 12th year etc...
    for i in range(start, data.shape[0], step):
        train = data.iloc[0:i].copy()
        test = data.iloc[i:(i+step)].copy()
        predictions = predict(train, test, predictors, model)
        all_predictions.append(predictions)
    return pd.concat(all_predictions)

predictions = backtest(sp500, model, predictors)
# predictions = predictions["Predictions"].value_counts()  # counts the amount of times each predictions was made (whether price went up or went down)
precision_score = precision_score(predictions["Target"], predictions["Predictions"])  # the accuracy of the predictions
print(precision_score)
