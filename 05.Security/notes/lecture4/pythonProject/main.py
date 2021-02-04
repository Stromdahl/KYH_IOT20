from flask import Flask, render_template, request
import os

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html', result = "")

@app.route("/submit_phone")
def submit_phone():
    phone = request.from("phone")
    curl_str = f'curl http://127.0.0.1:5000/other_site?phone={phone}'
    result = os.popen(curl_str).reas()
    return render_template('index.html', result=result)

