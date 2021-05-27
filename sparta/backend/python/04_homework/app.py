from flask import Flask, render_template, jsonify, request

app = Flask(__name__)

from pymongo import MongoClient

client = MongoClient('localhost', 27017)
db = client.dbhomework


## HTML 화면 보여주기
@app.route('/')
def homework():
    return render_template('index.html')


# 주문하기(POST)
@app.route('/order', methods=['POST'])
def save_order():
    # 데이터를 받는다.
    order_name = request.form['order-name']
    order_count = request.form['order-count']
    order_address = request.form['order-address']
    order_phone = request.form['order-phone']
    # json 형태에 맞게 저장한다.
    doc = {
        'order_name': order_name,
        'order_count': order_count,
        'order_address': order_address,
        'order_phone': order_phone
    }
    # mongoDB 에 저장한다.
    db.users.insert_one(doc)
    return jsonify({'msg': '주문이 완료되었습니다.'})


# 주문 목록보기(Read)
@app.route('/order', methods=['GET'])
def view_orders():

    return jsonify({'msg': '이 요청은 GET!'})


if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)
