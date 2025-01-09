const apiUrl = "/api/tasks";

// Carregar tarefas
async function loadTasks() {
  const response = await fetch(`${apiUrl}/all`);
  const tasks = await response.json();
  const taskList = document.getElementById("task-list");
  taskList.innerHTML = "";

  tasks.forEach((task) => {
    const taskCard = document.createElement("div");
    taskCard.className = "task-card";

    taskCard.innerHTML = `
              <h3>${task.title}</h3>
              <p>${task.description}</p>
              <p>Priority: ${task.priority}</p>
              <p>Status: ${task.status}</p>
              <p class="date">Registered on: ${new Date(
                task.registrationDate
              ).toLocaleString()}</p>
              <div class="task-actions">
                  <button class="edit-btn" onclick="editTask(${
                    task.id
                  })">Edit</button>
                  <button class="delete-btn" onclick="deleteTask(${
                    task.id
                  })">Delete</button>
              </div>
          `;

    taskList.appendChild(taskCard);
  });
}

// Adicionar tarefa
document
  .getElementById("task-form")
  .addEventListener("submit", async (event) => {
    event.preventDefault();

    const formData = new FormData(event.target);
    const taskData = Object.fromEntries(formData);

    await fetch(apiUrl, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(taskData),
    });

    event.target.reset();
    loadTasks();
  });

// Editar tarefa
async function editTask(id) {
  const newTitle = prompt("Enter new title:");
  const newDescription = prompt("Enter new description:");
  const newPriority = prompt("Enter new priority (LOW, MEDIUM, HIGH):");
  const newStatus = prompt(
    "Enter new status (PENDING, IN_PROGRESS, COMPLETED):"
  );

  const updatedTask = {
    title: newTitle,
    description: newDescription,
    priority: newPriority,
    status: newStatus,
  };

  await fetch(`${apiUrl}/id/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(updatedTask),
  });

  loadTasks();
}

// Excluir tarefa
async function deleteTask(id) {
  const confirmDelete = confirm(
    "Are you sure you want to delete this task?"
  );
  if (!confirmDelete) return;

  await fetch(`${apiUrl}/id/${id}`, { method: "DELETE" });
  loadTasks();
}

const editModal = document.getElementById("edit-modal");
const editForm = document.getElementById("edit-form");

// Abrir modal e preencher campos
async function editTask(id) {
  const response = await fetch(`${apiUrl}/id/${id}`);
  const task = await response.json();

  document.getElementById("edit-id").value = id;
  document.getElementById("edit-title").value = task.title;
  document.getElementById("edit-description").value = task.description;
  document.getElementById("edit-priority").value = task.priority;
  document.getElementById("edit-status").value = task.status;

  editModal.style.display = "flex";
}

// Fechar modal
function closeModal() {
  editModal.style.display = "none";
}

// Submeter alterações
editForm.addEventListener("submit", async (event) => {
  event.preventDefault();

  const id = document.getElementById("edit-id").value;
  const updatedTask = {
    title: document.getElementById("edit-title").value,
    description: document.getElementById("edit-description").value,
    priority: document.getElementById("edit-priority").value,
    status: document.getElementById("edit-status").value,
  };

  await fetch(`${apiUrl}/id/${id}`, {
    method: "PUT",
    headers: { "Content-Type": "application/json" },
    body: JSON.stringify(updatedTask),
  });

  closeModal();
  loadTasks();
});

// Carregar as tarefas ao iniciar
loadTasks();