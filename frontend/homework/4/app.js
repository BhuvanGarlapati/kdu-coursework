function addTask() {
    var input = document.getElementById('todoInput');
    var task = input.value.trim();

    if (task === '') {
        return; // Do nothing if the input is empty
    }

    var todoList = document.getElementById('todoList');
    var li = document.createElement('li');
    li.innerHTML = `
        <span>${task}</span>
        <button onclick="deleteTask(this)">DELETE</button>
    `;
    todoList.appendChild(li);

    // Clear the input field
    input.value = '';
}

function deleteTask(button) {
    var listItem = button.parentElement;
    listItem.remove();
}