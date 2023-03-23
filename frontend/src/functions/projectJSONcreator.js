export function projectJSONcreator(projectData, projectName) {
  let newProjectJSON = { projectName: projectName };
  projectData.forEach((table, index) => {
    console.log(table);
    newProjectJSON["table" + index] = {
      name: `${table.children[0].value}`,
      columns: {},
    };

    for (let i = 2; i < table.children.length; i++) {
      if (table.children[i].type == "text") {
        newProjectJSON["table" + index].columns[table.children[i].value] =
          table.children[i + 1].value;
      }
    }
  });
  console.log(newProjectJSON);
  return newProjectJSON;
}
