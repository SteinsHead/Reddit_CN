import pandas as pd  
from sklearn.cluster import KMeans  
from sklearn import preprocessing  
df = pd.read_csv('C:\\Users\\bank-all1.csv', usecols=['age', 'income'])  
data = df['income']  
df['Age_discretized'] = pd.cut(df.age, 4, labels=range(4))  
df.groupby('Age_discretized').count()  
data_re = data.values.reshape((data.index.size, 1))  
km_model = KMeans(n_clusters=4, random_state=2018)  
result = km_model.fit_predict(data_re)  
df['income_discretized'] = result    
df.groupby('income_discretized').count()  
print(df['income_discretized'])  