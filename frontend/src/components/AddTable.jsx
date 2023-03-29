import React, { useState } from "react";
import AddColumn from "./AddColumn";

function AddTable(props) {
  const [columns, setColumns] = useState([1]);
  const [include, setInclude] = useState(true);

  function addNewColumn() {
    setColumns([...columns, 1]);
  }

  return include ? (
    <div className={`table${props.tableCount}`}>
      <input type="text" name={`tablename`} placeholder="Table name" />
      <br />
      {columns.map((e, i) => {
        return <AddColumn key={i} columns={i} />;
      })}
      <button type="button" onClick={addNewColumn}>
        Add new column
      </button>
      <button className="removeTable" onClick={() => setInclude(false)}>
        Remove Table
      </button>
      <br />
    </div>
  ) : null;
}

export default AddTable;
