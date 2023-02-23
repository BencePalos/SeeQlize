const mysql = require("mysql");
const express = require("express");
const app = express();
const cors = require("cors");
const dotenv = require("dotenv");
dotenv.config();

app.use(express.json());
// app.use(express.static("public"));
app.use(cors());

const conn = mysql.createConnection({
  host: "localhost",
  user: "root",
  password: "password",
  database: "seeQlize",
});

conn.connect((error) => {
  if (error) {
    console.log("Something went wrong connecting to mySql");
  }
  console.log("Connection ok");
});

app.post("/auth/register", (req, res) => {
  let regData = req.body;
  console.log(regData);
  let err = { error: "Error while registering" };
  conn.query(
    "INSERT INTO users(username, password, email) VALUES(?,?,?)",
    [regData.username, regData.password, regData.email],
    (err, rows) => {
      if (err) {
        console.log(err);
        res.status(400);
        res.json(err);
      } else res.json({ suc: "Successful registration" });
    }
  );
});

app.post("/auth/login", (req, res) => {
  let loginData = req.body;
  conn.query(
    "SELECT * from users WHERE username = ? AND password=?",
    [loginData.username, loginData.password],
    (err, rows) => {
      if (err) {
        console.log("Login went wrong");
        res.status(400);
        res.json(err);
      }
      if (rows.length == 1) {
        res.status(200);
        res.json({ message: "Login successful" });
      } else {
        res.status(400);
        res.json({ message: "Login unsuccessful" });
      }
    }
  );
});

module.exports = app;
