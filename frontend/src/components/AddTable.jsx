import React, { useState } from "react";
import AddColumn from "./AddColumn";

function AddTable(props) {
  const [columns, setColumns] = useState([1]);

  function addNewColumn() {
    setColumns([...columns, 1]);
  }

  return (
    <div className={`table${props.tableCount}`}>
      <input
        type="text"
        name={`table${props.tableCount}name`}
        placeholder="Table name"
      />
      <br />
      {columns.map((e, i) => {
        return <AddColumn key={i} columns={columns.length} />;
      })}
      <button onClick={addNewColumn}>Add new column</button>
      <br />
    </div>
  );
}

export default AddTable;
