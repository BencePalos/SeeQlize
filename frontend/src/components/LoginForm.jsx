import { useNavigate } from "react-router";
import { loginUser } from "../functions/loginUser";

function LoginForm() {
  const navigate = useNavigate();
  async function handleLogin(e) {
    e.preventDefault();
    let loginData = {
      username: e.target.username.value,
      password: e.target.password.value,
    };

    let response = await loginUser(loginData);
    if (response) navigate("/");
  }

  return (
    <form onSubmit={handleLogin}>
      <input type="text" name="username" placeholder="username" />
      <input type="text" name="password" placeholder="password" />
      <button type="submit">Login</button>
    </form>
  );
}

export default LoginForm;
