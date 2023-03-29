export function projectJSONcreator(projectData, projectName) {
  let newProjectJSON = { projectName: projectName, tables: [] };
  projectData.forEach((table, index) => {
    // console.log(table);
    newProjectJSON.tables.push({
      tableName: `${table.children[0].value}`,
      columns: [],
    });
    let columnIndex = 0;
    for (let i = 2; i < table.children.length; i++) {
      if (table.children[i].type == "text") {
        newProjectJSON.tables[index].columns.push({
          // [table.children[i].value]: table.children[i + 1].value,
          columnName: table.children[i].value,
          columnType: table.children[i + 1].value,
        });
      }
    }
  });
  console.log(newProjectJSON);
  return newProjectJSON;
}
