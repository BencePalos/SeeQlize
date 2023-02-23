export async function registerUser(regData) {
  console.log(regData);
  let response = await fetch("http://127.0.0.1:8080/auth/register", {
    method: "POST",
    headers: {
      "content-type": "application/json",
    },
    body: JSON.stringify(regData),
  });
  let res = await response.json();

  if (response.status != 200) {
    alert("Something went wrong");
  } else return res;
}
