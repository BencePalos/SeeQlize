import React from "react";

function AddColumn(props) {
  return (
    <>
      <input
        type="text"
        placeholder="column name"
        name={`col${props.columns}name`}
      ></input>
      <select name={`col${props.columns}type`}>
        <option>text / varchar(255)</option>
        <option>number / int</option>
        <option>boolen</option>
      </select>
      <br />
    </>
  );
}

export default AddColumn;
