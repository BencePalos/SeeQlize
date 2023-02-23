import { registerUser } from "../functions/registerUser";

function RegisterForm() {
  async function handleRegister(e) {
    e.preventDefault();
    e.target.password.value === e.target.passwordAgain.value
      ? console.log("reg in progress")
      : alert("passwords don't match");

    let regData = {
      username: e.target.username.value,
      password: e.target.password.value,
      email: e.target.email.value,
    };
    console.log(regData);
    let response = await registerUser(regData);
    console.log(response);
  }
  return (
    <form onSubmit={handleRegister}>
      <input name="username" className="username" placeholder="username" />
      <input name="password" className="password" placeholder="password" />
      <input
        name="passwordAgain"
        className="passwordRepeat"
        placeholder="repeat password"
      />
      <input name="email" className="email" placeholder="email" />
      <button type="submit">Register</button>
    </form>
  );
}

export default RegisterForm;
