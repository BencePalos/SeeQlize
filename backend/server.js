const app = require("./app");
const PORT = process.env.PORT;

app.listen(PORT, (err) => {
  if (err) {
    console.log(err);
    return;
  }
  console.log(`App listening on port: ${PORT}`);
});
