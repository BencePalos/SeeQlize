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

module.exports = app;
