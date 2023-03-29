export async function loginUser(loginData) {
  let response = await fetch("http://127.0.0.1:8080/auth/login", {
    method: "POST",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(loginData),
  });

  let loginRes = await response.json();

  if (response.status != 200) {
    console.log(loginRes);
    alert("Something went wrong, please try again");
  } else {
    return loginRes;
  }
}
