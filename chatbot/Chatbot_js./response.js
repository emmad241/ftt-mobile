const responseObj = {
    hello: "Hey ! How are you doing ?",
    hi: "Good to see you again",
    'good day': "Hi there, how can I help?",
    'how are you': "I'm good! And you?",
    'good': ":) Great What can i help you today? ",
    "i'm good": ":) Great! What can i help you today? ",
    "i'm fine": ":) Great! What can i help you today? ",
    hey: "Hey! What's Up",
    thanks: "Any time!",
    'thank you': "My pleasure",
    'thanks for helping': "Happy to help!",
    bye: "See you later",
    'nice to meet you': 'nice to meet you too!',
    pleasure: "It's my pleasure to talk to you!",
    options: "I can list out top 5 stocks this week, and give you some information about each stock",
    'what option you have' :"I can list out top 5 stocks this week, and give you some information about each stock",
    'what do you do': "I can list out top 5 stocks this week, and give you some information about each stock",
    option:"I can list out top 5 stocks this week, and give you some information about each stock",
    feature:"I can list out top 5 stocks this week, and give you some information about each stock",
    features:"I can list out top 5 stocks this week, and give you some information about each stock",
    'what features you have':"I can list out top 5 stocks this week, and give you some information about each stock",
    'what can you do': "I can list out top 5 stocks this week, and give you some information about each stock",
    'what help you provide': "I can list out top 5 stocks this week, and give you some information about each stock",
    'what support is offered': "I can list out top 5 stocks this week, and give you some information about each stock",
    support: "I can list out top 5 stocks this week, and give you some information about each stock",
    top: "Occidental Petroleum(OXY)\nPure Storage(PSTG)\nLivent(LTHM)\nTexas Roadhouse(TXRH)\nShift4 Payment(FOUR)",
    "what's top 5 stock for this week": "Occidental Petroleum(OXY)\nPure Storage(PSTG)\nLivent(LTHM)\nTexas Roadhouse(TXRH)\nShift4 Payment(FOUR)",
    'top 5' :"Occidental Petroleum(OXY)\nPure Storage(PSTG)\nLivent(LTHM)\nTexas Roadhouse(TXRH)\nShift4 Payment(FOUR)",
    'best stocks':"Occidental Petroleum(OXY)\nPure Storage(PSTG)\nLivent(LTHM)\nTexas Roadhouse(TXRH)\nShift4 Payment(FOUR)",
    "what's best stock":"Occidental Petroleum(OXY)\nPure Storage(PSTG)\nLivent(LTHM)\nTexas Roadhouse(TXRH)\nShift4 Payment(FOUR)",
    'show me best stock':"Occidental Petroleum(OXY)\nPure Storage(PSTG)\nLivent(LTHM)\nTexas Roadhouse(TXRH)\nShift4 Payment(FOUR)",
    "what's top 5":"Occidental Petroleum(OXY)\nPure Storage(PSTG)\nLivent(LTHM)\nTexas Roadhouse(TXRH)\nShift4 Payment(FOUR)",
    'valuable stocks':"Occidental Petroleum(OXY)\nPure Storage(PSTG)\nLivent(LTHM)\nTexas Roadhouse(TXRH)\nShift4 Payment(FOUR)",
    'top stocks':"Occidental Petroleum(OXY)\nPure Storage(PSTG)\nLivent(LTHM)\nTexas Roadhouse(TXRH)\nShift4 Payment(FOUR)",
    oxy: "The Warren Buffett stock is in a buy zone after previously crossing the 72.14 buy point from a cup-with-handle base, according to MarketSmith analyis.\nThe stock is up more than 138% so far this year, far outperforming the broader stock market.\nAnalysts predict Occidental will report a profit of $10.24 per share in 2022, up more than 300% from last year. Sales are expected to jump 43% to $37.3 billion over the same period.",
    'why oxy': "The Warren Buffett stock is in a buy zone after previously crossing the 72.14 buy point from a cup-with-handle base, according to MarketSmith analyis.\nThe stock is up more than 138% so far this year, far outperforming the broader stock market.\nAnalysts predict Occidental will report a profit of $10.24 per share in 2022, up more than 300% from last year. Sales are expected to jump 43% to $37.3 billion over the same period.",
    'info of oxy':"The Warren Buffett stock is in a buy zone after previously crossing the 72.14 buy point from a cup-with-handle base, according to MarketSmith analyis.\nThe stock is up more than 138% so far this year, far outperforming the broader stock market.\nAnalysts predict Occidental will report a profit of $10.24 per share in 2022, up more than 300% from last year. Sales are expected to jump 43% to $37.3 billion over the same period.",
    "occidental Petroleum" :"The Warren Buffett stock is in a buy zone after previously crossing the 72.14 buy point from a cup-with-handle base, according to MarketSmith analyis.\nThe stock is up more than 138% so far this year, far outperforming the broader stock market.\nAnalysts predict Occidental will report a profit of $10.24 per share in 2022, up more than 300% from last year. Sales are expected to jump 43% to $37.3 billion over the same period.",
    "show me information of oxy":"The Warren Buffett stock is in a buy zone after previously crossing the 72.14 buy point from a cup-with-handle base, according to MarketSmith analyis.\nThe stock is up more than 138% so far this year, far outperforming the broader stock market.\nAnalysts predict Occidental will report a profit of $10.24 per share in 2022, up more than 300% from last year. Sales are expected to jump 43% to $37.3 billion over the same period.",
    "why oxy is one of top stock this week?":"The Warren Buffett stock is in a buy zone after previously crossing the 72.14 buy point from a cup-with-handle base, according to MarketSmith analyis.\nThe stock is up more than 138% so far this year, far outperforming the broader stock market.\nAnalysts predict Occidental will report a profit of $10.24 per share in 2022, up more than 300% from last year. Sales are expected to jump 43% to $37.3 billion over the same period.",
    "what makes oxy top 5 this week? ":"The Warren Buffett stock is in a buy zone after previously crossing the 72.14 buy point from a cup-with-handle base, according to MarketSmith analyis.\nThe stock is up more than 138% so far this year, far outperforming the broader stock market.\nAnalysts predict Occidental will report a profit of $10.24 per share in 2022, up more than 300% from last year. Sales are expected to jump 43% to $37.3 billion over the same period.",
    "what's oxy":"The Warren Buffett stock is in a buy zone after previously crossing the 72.14 buy point from a cup-with-handle base, according to MarketSmith analyis.\nThe stock is up more than 138% so far this year, far outperforming the broader stock market.\nAnalysts predict Occidental will report a profit of $10.24 per share in 2022, up more than 300% from last year. Sales are expected to jump 43% to $37.3 billion over the same period.",
    "give me some information about oxy":"The Warren Buffett stock is in a buy zone after previously crossing the 72.14 buy point from a cup-with-handle base, according to MarketSmith analyis.\nThe stock is up more than 138% so far this year, far outperforming the broader stock market.\nAnalysts predict Occidental will report a profit of $10.24 per share in 2022, up more than 300% from last year. Sales are expected to jump 43% to $37.3 billion over the same period.",
    "some information about oxy":"The Warren Buffett stock is in a buy zone after previously crossing the 72.14 buy point from a cup-with-handle base, according to MarketSmith analyis.\nThe stock is up more than 138% so far this year, far outperforming the broader stock market.\nAnalysts predict Occidental will report a profit of $10.24 per share in 2022, up more than 300% from last year. Sales are expected to jump 43% to $37.3 billion over the same period.",
    "oxy information":"The Warren Buffett stock is in a buy zone after previously crossing the 72.14 buy point from a cup-with-handle base, according to MarketSmith analyis.\nThe stock is up more than 138% so far this year, far outperforming the broader stock market.\nAnalysts predict Occidental will report a profit of $10.24 per share in 2022, up more than 300% from last year. Sales are expected to jump 43% to $37.3 billion over the same period.",
    "why oxy top 5":"The Warren Buffett stock is in a buy zone after previously crossing the 72.14 buy point from a cup-with-handle base, according to MarketSmith analyis.\nThe stock is up more than 138% so far this year, far outperforming the broader stock market.\nAnalysts predict Occidental will report a profit of $10.24 per share in 2022, up more than 300% from last year. Sales are expected to jump 43% to $37.3 billion over the same period.",
    'i want know more about oxy':"The Warren Buffett stock is in a buy zone after previously crossing the 72.14 buy point from a cup-with-handle base, according to MarketSmith analyis.\nThe stock is up more than 138% so far this year, far outperforming the broader stock market.\nAnalysts predict Occidental will report a profit of $10.24 per share in 2022, up more than 300% from last year. Sales are expected to jump 43% to $37.3 billion over the same period.",
    pstg: "PSTG stock is also one of the best stocks to buy or watch now. It has just cleared a consolidation pattern buy point of 31.62.\nThe base, which started on Aug. 18, is within a much-larger consolidation. Excellent all-around performance is reflected in its IBD Composite Rating of 93 out of 99.\nEarnings are its biggest strength, with the stock holding a rare perfect EPS Rating. Its revenue jumped 30% from the year-earlier period to $646.8 million.\nSubscription services revenue grew 35% to $232.2 million. And it posted adjusted earnings of 32 cents a share, up 128%. ",
    'why pstg': "PSTG stock is also one of the best stocks to buy or watch now. It has just cleared a consolidation pattern buy point of 31.62.\nThe base, which started on Aug. 18, is within a much-larger consolidation. Excellent all-around performance is reflected in its IBD Composite Rating of 93 out of 99.\nEarnings are its biggest strength, with the stock holding a rare perfect EPS Rating. Its revenue jumped 30% from the year-earlier period to $646.8 million.\nSubscription services revenue grew 35% to $232.2 million. And it posted adjusted earnings of 32 cents a share, up 128%. ",
    'why pstg top 5': "PSTG stock is also one of the best stocks to buy or watch now. It has just cleared a consolidation pattern buy point of 31.62.\nThe base, which started on Aug. 18, is within a much-larger consolidation. Excellent all-around performance is reflected in its IBD Composite Rating of 93 out of 99.\nEarnings are its biggest strength, with the stock holding a rare perfect EPS Rating. Its revenue jumped 30% from the year-earlier period to $646.8 million.\nSubscription services revenue grew 35% to $232.2 million. And it posted adjusted earnings of 32 cents a share, up 128%. ",
    'give me some information about pstg': "PSTG stock is also one of the best stocks to buy or watch now. It has just cleared a consolidation pattern buy point of 31.62.\nThe base, which started on Aug. 18, is within a much-larger consolidation. Excellent all-around performance is reflected in its IBD Composite Rating of 93 out of 99.\nEarnings are its biggest strength, with the stock holding a rare perfect EPS Rating. Its revenue jumped 30% from the year-earlier period to $646.8 million.\nSubscription services revenue grew 35% to $232.2 million. And it posted adjusted earnings of 32 cents a share, up 128%. ",
    "information about pstg":"PSTG stock is also one of the best stocks to buy or watch now. It has just cleared a consolidation pattern buy point of 31.62.\nThe base, which started on Aug. 18, is within a much-larger consolidation. Excellent all-around performance is reflected in its IBD Composite Rating of 93 out of 99.\nEarnings are its biggest strength, with the stock holding a rare perfect EPS Rating. Its revenue jumped 30% from the year-earlier period to $646.8 million.\nSubscription services revenue grew 35% to $232.2 million. And it posted adjusted earnings of 32 cents a share, up 128%. ",
    "pure storage":"PSTG stock is also one of the best stocks to buy or watch now. It has just cleared a consolidation pattern buy point of 31.62.\nThe base, which started on Aug. 18, is within a much-larger consolidation. Excellent all-around performance is reflected in its IBD Composite Rating of 93 out of 99.\nEarnings are its biggest strength, with the stock holding a rare perfect EPS Rating. Its revenue jumped 30% from the year-earlier period to $646.8 million.\nSubscription services revenue grew 35% to $232.2 million. And it posted adjusted earnings of 32 cents a share, up 128%. ",
    "what's ptsg":"PSTG stock is also one of the best stocks to buy or watch now. It has just cleared a consolidation pattern buy point of 31.62.\nThe base, which started on Aug. 18, is within a much-larger consolidation. Excellent all-around performance is reflected in its IBD Composite Rating of 93 out of 99.\nEarnings are its biggest strength, with the stock holding a rare perfect EPS Rating. Its revenue jumped 30% from the year-earlier period to $646.8 million.\nSubscription services revenue grew 35% to $232.2 million. And it posted adjusted earnings of 32 cents a share, up 128%. ",
    "show me infomation of pstg":"PSTG stock is also one of the best stocks to buy or watch now. It has just cleared a consolidation pattern buy point of 31.62.\nThe base, which started on Aug. 18, is within a much-larger consolidation. Excellent all-around performance is reflected in its IBD Composite Rating of 93 out of 99.\nEarnings are its biggest strength, with the stock holding a rare perfect EPS Rating. Its revenue jumped 30% from the year-earlier period to $646.8 million.\nSubscription services revenue grew 35% to $232.2 million. And it posted adjusted earnings of 32 cents a share, up 128%. ",
    "why pstg is one of top stock this week? ":"PSTG stock is also one of the best stocks to buy or watch now. It has just cleared a consolidation pattern buy point of 31.62.\nThe base, which started on Aug. 18, is within a much-larger consolidation. Excellent all-around performance is reflected in its IBD Composite Rating of 93 out of 99.\nEarnings are its biggest strength, with the stock holding a rare perfect EPS Rating. Its revenue jumped 30% from the year-earlier period to $646.8 million.\nSubscription services revenue grew 35% to $232.2 million. And it posted adjusted earnings of 32 cents a share, up 128%. ",
    "what makes pstg top 5 this week?":"PSTG stock is also one of the best stocks to buy or watch now. It has just cleared a consolidation pattern buy point of 31.62.\nThe base, which started on Aug. 18, is within a much-larger consolidation. Excellent all-around performance is reflected in its IBD Composite Rating of 93 out of 99.\nEarnings are its biggest strength, with the stock holding a rare perfect EPS Rating. Its revenue jumped 30% from the year-earlier period to $646.8 million.\nSubscription services revenue grew 35% to $232.2 million. And it posted adjusted earnings of 32 cents a share, up 128%. ",
    'i want know more about pstg':"PSTG stock is also one of the best stocks to buy or watch now. It has just cleared a consolidation pattern buy point of 31.62.\nThe base, which started on Aug. 18, is within a much-larger consolidation. Excellent all-around performance is reflected in its IBD Composite Rating of 93 out of 99.\nEarnings are its biggest strength, with the stock holding a rare perfect EPS Rating. Its revenue jumped 30% from the year-earlier period to $646.8 million.\nSubscription services revenue grew 35% to $232.2 million. And it posted adjusted earnings of 32 cents a share, up 128%. ",
    lthm:"Livent stock is holding right at its 10-week and 50-day moving averages. A solid jump above its 50-day line could offer an early entry point for aggressive investors.\nThe potential buy point here is 36.48. Livent previously raised full-year revenue guidance to a range of $800 million to $860 million, up from $755 million to $835 million.\nThe spot price for lithium carbonate in China rose to nearly $78,000 per ton last week, an all time high and up about 130% on the year. ",
    'why lthm':"Livent stock is holding right at its 10-week and 50-day moving averages. A solid jump above its 50-day line could offer an early entry point for aggressive investors.\nThe potential buy point here is 36.48. Livent previously raised full-year revenue guidance to a range of $800 million to $860 million, up from $755 million to $835 million.\nThe spot price for lithium carbonate in China rose to nearly $78,000 per ton last week, an all time high and up about 130% on the year. ",
    "what makes lthm top 5 this week?":"Livent stock is holding right at its 10-week and 50-day moving averages. A solid jump above its 50-day line could offer an early entry point for aggressive investors.\nThe potential buy point here is 36.48. Livent previously raised full-year revenue guidance to a range of $800 million to $860 million, up from $755 million to $835 million.\nThe spot price for lithium carbonate in China rose to nearly $78,000 per ton last week, an all time high and up about 130% on the year. ",
    "why lthm is one of top stock this week?":"Livent stock is holding right at its 10-week and 50-day moving averages. A solid jump above its 50-day line could offer an early entry point for aggressive investors.\nThe potential buy point here is 36.48. Livent previously raised full-year revenue guidance to a range of $800 million to $860 million, up from $755 million to $835 million.\nThe spot price for lithium carbonate in China rose to nearly $78,000 per ton last week, an all time high and up about 130% on the year. ",
    "why lthm top 5":"Livent stock is holding right at its 10-week and 50-day moving averages. A solid jump above its 50-day line could offer an early entry point for aggressive investors.\nThe potential buy point here is 36.48. Livent previously raised full-year revenue guidance to a range of $800 million to $860 million, up from $755 million to $835 million.\nThe spot price for lithium carbonate in China rose to nearly $78,000 per ton last week, an all time high and up about 130% on the year. ",
    "give me some information about lthm":"Livent stock is holding right at its 10-week and 50-day moving averages. A solid jump above its 50-day line could offer an early entry point for aggressive investors.\nThe potential buy point here is 36.48. Livent previously raised full-year revenue guidance to a range of $800 million to $860 million, up from $755 million to $835 million.\nThe spot price for lithium carbonate in China rose to nearly $78,000 per ton last week, an all time high and up about 130% on the year. ",
    "show me information of lthm":"Livent stock is holding right at its 10-week and 50-day moving averages. A solid jump above its 50-day line could offer an early entry point for aggressive investors.\nThe potential buy point here is 36.48. Livent previously raised full-year revenue guidance to a range of $800 million to $860 million, up from $755 million to $835 million.\nThe spot price for lithium carbonate in China rose to nearly $78,000 per ton last week, an all time high and up about 130% on the year. ",
    "livent":"Livent stock is holding right at its 10-week and 50-day moving averages. A solid jump above its 50-day line could offer an early entry point for aggressive investors.\nThe potential buy point here is 36.48. Livent previously raised full-year revenue guidance to a range of $800 million to $860 million, up from $755 million to $835 million.\nThe spot price for lithium carbonate in China rose to nearly $78,000 per ton last week, an all time high and up about 130% on the year. ",
    "information about lthm":"Livent stock is holding right at its 10-week and 50-day moving averages. A solid jump above its 50-day line could offer an early entry point for aggressive investors.\nThe potential buy point here is 36.48. Livent previously raised full-year revenue guidance to a range of $800 million to $860 million, up from $755 million to $835 million.\nThe spot price for lithium carbonate in China rose to nearly $78,000 per ton last week, an all time high and up about 130% on the year. ",
    "what's lthm":"Livent stock is holding right at its 10-week and 50-day moving averages. A solid jump above its 50-day line could offer an early entry point for aggressive investors.\nThe potential buy point here is 36.48. Livent previously raised full-year revenue guidance to a range of $800 million to $860 million, up from $755 million to $835 million.\nThe spot price for lithium carbonate in China rose to nearly $78,000 per ton last week, an all time high and up about 130% on the year. ",
    'i want know more about lthm':"Livent stock is holding right at its 10-week and 50-day moving averages. A solid jump above its 50-day line could offer an early entry point for aggressive investors.\nThe potential buy point here is 36.48. Livent previously raised full-year revenue guidance to a range of $800 million to $860 million, up from $755 million to $835 million.\nThe spot price for lithium carbonate in China rose to nearly $78,000 per ton last week, an all time high and up about 130% on the year. ",
    txrh:"Texas Roadhouse is trading in a buy zone after previously clearing a flat-base entry point of 95.52. It comes after it previously broke past an early trendline entry.\nTXRH stock undercut its buy point on Friday following earnings, but rebounded from its 21-day line to close down just 4 cents at 98.71.\nIt is now moving higher still. Overall powerful performance is reflected in an IBD Composite Rating of 93.\nThe stock has seen its price pop by over 13% over the past four weeks alone.",
    'why txrh':"Texas Roadhouse is trading in a buy zone after previously clearing a flat-base entry point of 95.52. It comes after it previously broke past an early trendline entry.\nTXRH stock undercut its buy point on Friday following earnings, but rebounded from its 21-day line to close down just 4 cents at 98.71.\nIt is now moving higher still. Overall powerful performance is reflected in an IBD Composite Rating of 93.\nThe stock has seen its price pop by over 13% over the past four weeks alone.",
    "information about txrh":"Texas Roadhouse is trading in a buy zone after previously clearing a flat-base entry point of 95.52. It comes after it previously broke past an early trendline entry.\nTXRH stock undercut its buy point on Friday following earnings, but rebounded from its 21-day line to close down just 4 cents at 98.71.\nIt is now moving higher still. Overall powerful performance is reflected in an IBD Composite Rating of 93.\nThe stock has seen its price pop by over 13% over the past four weeks alone.",
    "texas Roadhouse":"Texas Roadhouse is trading in a buy zone after previously clearing a flat-base entry point of 95.52. It comes after it previously broke past an early trendline entry.\nTXRH stock undercut its buy point on Friday following earnings, but rebounded from its 21-day line to close down just 4 cents at 98.71.\nIt is now moving higher still. Overall powerful performance is reflected in an IBD Composite Rating of 93.\nThe stock has seen its price pop by over 13% over the past four weeks alone.",
    "show me information of txrh":"Texas Roadhouse is trading in a buy zone after previously clearing a flat-base entry point of 95.52. It comes after it previously broke past an early trendline entry.\nTXRH stock undercut its buy point on Friday following earnings, but rebounded from its 21-day line to close down just 4 cents at 98.71.\nIt is now moving higher still. Overall powerful performance is reflected in an IBD Composite Rating of 93.\nThe stock has seen its price pop by over 13% over the past four weeks alone.",
    "why txrh is one of top stock this week?":"Texas Roadhouse is trading in a buy zone after previously clearing a flat-base entry point of 95.52. It comes after it previously broke past an early trendline entry.\nTXRH stock undercut its buy point on Friday following earnings, but rebounded from its 21-day line to close down just 4 cents at 98.71.\nIt is now moving higher still. Overall powerful performance is reflected in an IBD Composite Rating of 93.\nThe stock has seen its price pop by over 13% over the past four weeks alone.",
    "what makes txrh top 5 this week?":"Texas Roadhouse is trading in a buy zone after previously clearing a flat-base entry point of 95.52. It comes after it previously broke past an early trendline entry.\nTXRH stock undercut its buy point on Friday following earnings, but rebounded from its 21-day line to close down just 4 cents at 98.71.\nIt is now moving higher still. Overall powerful performance is reflected in an IBD Composite Rating of 93.\nThe stock has seen its price pop by over 13% over the past four weeks alone.",
    "why txrh top 5":"Texas Roadhouse is trading in a buy zone after previously clearing a flat-base entry point of 95.52. It comes after it previously broke past an early trendline entry.\nTXRH stock undercut its buy point on Friday following earnings, but rebounded from its 21-day line to close down just 4 cents at 98.71.\nIt is now moving higher still. Overall powerful performance is reflected in an IBD Composite Rating of 93.\nThe stock has seen its price pop by over 13% over the past four weeks alone.",
    "give me some information about txrh":"Texas Roadhouse is trading in a buy zone after previously clearing a flat-base entry point of 95.52. It comes after it previously broke past an early trendline entry.\nTXRH stock undercut its buy point on Friday following earnings, but rebounded from its 21-day line to close down just 4 cents at 98.71.\nIt is now moving higher still. Overall powerful performance is reflected in an IBD Composite Rating of 93.\nThe stock has seen its price pop by over 13% over the past four weeks alone.",
    "texas Roadhouse":"Texas Roadhouse is trading in a buy zone after previously clearing a flat-base entry point of 95.52. It comes after it previously broke past an early trendline entry.\nTXRH stock undercut its buy point on Friday following earnings, but rebounded from its 21-day line to close down just 4 cents at 98.71.\nIt is now moving higher still. Overall powerful performance is reflected in an IBD Composite Rating of 93.\nThe stock has seen its price pop by over 13% over the past four weeks alone.",
    "what's txrh":"Texas Roadhouse is trading in a buy zone after previously clearing a flat-base entry point of 95.52. It comes after it previously broke past an early trendline entry.\nTXRH stock undercut its buy point on Friday following earnings, but rebounded from its 21-day line to close down just 4 cents at 98.71.\nIt is now moving higher still. Overall powerful performance is reflected in an IBD Composite Rating of 93.\nThe stock has seen its price pop by over 13% over the past four weeks alone.",
    four:"Payments stock FOUR built a bottoming base that goes as deep as 14% below its entry point. It is offering a buy point at 51.52.\nIn addition, investors should watch for a strong move above its 50-day or 200-day moving averages.\nThe Oct. 20 high of 48.66 might offer a specific early entry. Improving technical performance has lifted its IBD Composite Rating to 75 out of 99.\nAlso, Shift4 acquired software maker VenueNext for $72 million in March 2021 as it targets sports stadiums. ",
    'why four':"Payments stock FOUR built a bottoming base that goes as deep as 14% below its entry point. It is offering a buy point at 51.52.\nIn addition, investors should watch for a strong move above its 50-day or 200-day moving averages.\nThe Oct. 20 high of 48.66 might offer a specific early entry. Improving technical performance has lifted its IBD Composite Rating to 75 out of 99.\nAlso, Shift4 acquired software maker VenueNext for $72 million in March 2021 as it targets sports stadiums. ",
    "information about four":"Payments stock FOUR built a bottoming base that goes as deep as 14% below its entry point. It is offering a buy point at 51.52.\nIn addition, investors should watch for a strong move above its 50-day or 200-day moving averages.\nThe Oct. 20 high of 48.66 might offer a specific early entry. Improving technical performance has lifted its IBD Composite Rating to 75 out of 99.\nAlso, Shift4 acquired software maker VenueNext for $72 million in March 2021 as it targets sports stadiums. ",
    "shift4 Payment":"Payments stock FOUR built a bottoming base that goes as deep as 14% below its entry point. It is offering a buy point at 51.52.\nIn addition, investors should watch for a strong move above its 50-day or 200-day moving averages.\nThe Oct. 20 high of 48.66 might offer a specific early entry. Improving technical performance has lifted its IBD Composite Rating to 75 out of 99.\nAlso, Shift4 acquired software maker VenueNext for $72 million in March 2021 as it targets sports stadiums. ",
    "show me information of four":"Payments stock FOUR built a bottoming base that goes as deep as 14% below its entry point. It is offering a buy point at 51.52.\nIn addition, investors should watch for a strong move above its 50-day or 200-day moving averages.\nThe Oct. 20 high of 48.66 might offer a specific early entry. Improving technical performance has lifted its IBD Composite Rating to 75 out of 99.\nAlso, Shift4 acquired software maker VenueNext for $72 million in March 2021 as it targets sports stadiums. ",
    "why four is one of top stock this week?":"Payments stock FOUR built a bottoming base that goes as deep as 14% below its entry point. It is offering a buy point at 51.52.\nIn addition, investors should watch for a strong move above its 50-day or 200-day moving averages.\nThe Oct. 20 high of 48.66 might offer a specific early entry. Improving technical performance has lifted its IBD Composite Rating to 75 out of 99.\nAlso, Shift4 acquired software maker VenueNext for $72 million in March 2021 as it targets sports stadiums. ",
    "why four top 5":"Payments stock FOUR built a bottoming base that goes as deep as 14% below its entry point. It is offering a buy point at 51.52.\nIn addition, investors should watch for a strong move above its 50-day or 200-day moving averages.\nThe Oct. 20 high of 48.66 might offer a specific early entry. Improving technical performance has lifted its IBD Composite Rating to 75 out of 99.\nAlso, Shift4 acquired software maker VenueNext for $72 million in March 2021 as it targets sports stadiums. ",
    "what's four":"Payments stock FOUR built a bottoming base that goes as deep as 14% below its entry point. It is offering a buy point at 51.52.\nIn addition, investors should watch for a strong move above its 50-day or 200-day moving averages.\nThe Oct. 20 high of 48.66 might offer a specific early entry. Improving technical performance has lifted its IBD Composite Rating to 75 out of 99.\nAlso, Shift4 acquired software maker VenueNext for $72 million in March 2021 as it targets sports stadiums. ",
    "give my some information about four":"Payments stock FOUR built a bottoming base that goes as deep as 14% below its entry point. It is offering a buy point at 51.52.\nIn addition, investors should watch for a strong move above its 50-day or 200-day moving averages.\nThe Oct. 20 high of 48.66 might offer a specific early entry. Improving technical performance has lifted its IBD Composite Rating to 75 out of 99.\nAlso, Shift4 acquired software maker VenueNext for $72 million in March 2021 as it targets sports stadiums. ",
    "what makes four top 5 this week?":"Payments stock FOUR built a bottoming base that goes as deep as 14% below its entry point. It is offering a buy point at 51.52.\nIn addition, investors should watch for a strong move above its 50-day or 200-day moving averages.\nThe Oct. 20 high of 48.66 might offer a specific early entry. Improving technical performance has lifted its IBD Composite Rating to 75 out of 99.\nAlso, Shift4 acquired software maker VenueNext for $72 million in March 2021 as it targets sports stadiums. ",
    'i want know more about four':"Payments stock FOUR built a bottoming base that goes as deep as 14% below its entry point. It is offering a buy point at 51.52.\nIn addition, investors should watch for a strong move above its 50-day or 200-day moving averages.\nThe Oct. 20 high of 48.66 might offer a specific early entry. Improving technical performance has lifted its IBD Composite Rating to 75 out of 99.\nAlso, Shift4 acquired software maker VenueNext for $72 million in March 2021 as it targets sports stadiums. ",
    'buy stocks':"Please login or register in order to do that.",
    'buy stock':"Please login or register in order to do that.",
    'i want buy stock':"Please login or register in order to do that.",
    'pay for stock':"Please login or register in order to do that.",
    "check my stocks":"Please login or register in order to do that.",
    "is any update of my stock":"Please login or register in order to do that.",
    'my stocks': "Please login or register in order to do that.",
    "movement of stock":"Please login or register in order to do that.",
    'help':'Perhaps you like to talk to one of our human support? ',
    'i need help': 'Would you like to leave your problem? Our customer support will with you shortly',
    'my stock': "Please login or register in order to do that.",
    'stock movement': "Please login or register in order to do that.",
    'profile update':"Please login or register in order to do that.",
    'i want update my profile':"Please login or register in order to do that.",
    'i want get update of my stock':"Please login or register in order to do that.",
    today: new Date().toDateString(),
    time: new Date().toLocaleTimeString(),
    };
