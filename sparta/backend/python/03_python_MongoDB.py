from pymongo import MongoClient

client = MongoClient('localhost', 27017)
db = client.schema

# insert
doc = {'name': 'kim', 'age': 25}
db.users.insert_one(doc)
doc = [{'name': 'min', 'age': 20}, {'name': 'jun', 'age': 23}]
db.users.insert_many(doc)

# find
same_ages = list(db.users.find({'age': 21}, {'_id': False}))
user = db.users.find_one({'name': 'bobby'}, {'_id': False})

# update
db.users.update_one({'name': 'bobby'}, {'$set': {'age': 19}})
db.users.update_many({'age': 19}, {'$set': {'name': 'adult'}})

# delete
db.users.delete_one({'name': 'bobby'})
