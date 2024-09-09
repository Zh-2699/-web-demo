<!-- TaskModal.vue -->
<template>
  <div class="modal-overlay" @click.self="close">
    <div class="modal">
      <header class="modal-header">
        <slot name="header">
          <h2>任务详情</h2>
        </slot>
      </header>
      <section class="modal-body">
        <slot name="body">
          <div class="form-group">
            <label for="task-title">任务标题</label>
            <input id="task-title" v-model="taskTitle" type="text" class="form-control" />
          </div>
          <div class="form-group">
            <label>任务颜色</label>
            <div class="color-picker">
              <button
                v-for="color in colors"
                :key="color"
                :style="{ backgroundColor: color }"
                :class="{ selected: taskColor === color }"
                @click="selectColor(color)"
                class="color-button"
              ></button>
            </div>
          </div>
        </slot>
      </section>
      <footer class="modal-footer">
        <slot name="footer">
          <button @click="saveTask" class="btn-save">保存</button>
          <button @click="close" class="btn-close">关闭</button>
          <button @click="deleteTask" class="btn-delete">删除</button>
        </slot>
      </footer>
    </div>
  </div>
</template>

<script setup>
import { ref, watch } from 'vue';

const props = defineProps({
  show: Boolean,
  task: Object,
});

const emit = defineEmits(['close', 'save', 'delete']);

const taskTitle = ref(props.task.title);
const taskColor = ref(props.task.color);
const colors = ['#2081e2', '#FCDB00', '#20B759', '#FC5143', '#FF33A1'];

watch(() => props.task, (newTask) => {
  taskTitle.value = newTask.title;
  taskColor.value = newTask.color;
});

const close = () => {
  emit('close');
};

const saveTask = () => {
  emit('save', { title: taskTitle.value, color: taskColor.value });
  close();
};

const deleteTask = () => {
  emit('delete', props.task);
  close();
};

const selectColor = (color) => {
  taskColor.value = color;
};
</script>

<style scoped>
/* 保留现有样式 */
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 1000;
}

.modal {
  background: white;
  padding: 20px;
  border-radius: 5px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  width: 500px;
  max-width: 100%;
}

.modal-header {
  margin-bottom: 20px;
}

.form-group {
  margin-bottom: 20px;
}

.form-control {
  width: 100%;
  padding: 8px;
  box-sizing: border-box;
  border: 1px solid #ccc;
  border-radius: 5px;
  margin-top: 30px;
}

.color-picker {
  display: flex;
  gap: 10px;
  margin-top: 20px;
}

.color-button {
  width: 40px;
  height: 40px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.color-button.selected {
  border: 3px solid #000;
}

.modal-footer {
  display: flex;
  justify-content: flex-end;
  gap: 10px;
}

.btn-save {
  background-color: #2081e2;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.btn-close {
  background-color: #ccc;
  color: black;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.btn-delete {
  background-color: #ff4d4f;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
</style>
