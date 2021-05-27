from flask import Flask, render_template, request, jsonify

app = Flask(__name__)


@app.route('/')
def home():
    return render_template('index.html')


@app.route('/test', methods=['GET'])
def test_get():
    title_receive = request.args.get('title_give')
    print(title_receive)
    return jsonify({'result': 'success', 'msg': '이 요청은 GET!'})


@app.route('/test', methods=['POST'])
def test_post():
    post_body_parameter = request.form['body_parameter']
    return jsonify({'result': 'success', 'msg': '이 요청을 주셨나요?' + post_body_parameter})


if __name__ == '__main__':
    app.run('0.0.0.0', port=5000, debug=True)
