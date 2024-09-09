<!-- GoalsComponent.vue -->
<template>
  <div class="outer-container">
    <div class="goals-container">
      <header class="goals-header">
        <h2>#目标</h2>
        <button class="new-task-btn">+ New Goal</button>
      </header>
      <div class="goals-board">
        <div class="task-column">
          <!-- 新任务 -->

          <h3 class="column-title">
            <svg t="1716907745973" class="icon"  viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="6327" width="200" height="200">
            <path d="M885.333333 981.333333H181.333333a53.393333 53.393333 0 0 1-53.333333-53.333333V224a53.393333 53.393333 0 0 1 53.333333-53.333333h53.333334a21.333333 21.333333 0 0 1 0 42.666666h-53.333334a10.666667 10.666667 0 0 0-10.666666 10.666667v704a10.666667 10.666667 0 0 0 10.666666 10.666667h704a10.666667 10.666667 0 0 0 10.666667-10.666667V224a10.666667 10.666667 0 0 0-10.666667-10.666667h-53.333333a21.333333 21.333333 0 0 1 0-42.666666h53.333333a53.393333 53.393333 0 0 1 53.333334 53.333333v704a53.393333 53.393333 0 0 1-53.333334 53.333333z m-522.666666-170.666666a21.266667 21.266667 0 0 1-15.086667-6.246667l-42.666667-42.666667a21.333333 21.333333 0 0 1 30.173334-30.173333l27.58 27.586667 70.246666-70.253334a21.333333 21.333333 0 0 1 30.173334 30.173334l-85.333334 85.333333A21.266667 21.266667 0 0 1 362.666667 810.666667z m384-42.666667H533.333333a21.333333 21.333333 0 0 1 0-42.666667h213.333334a21.333333 21.333333 0 0 1 0 42.666667zM362.666667 640a21.266667 21.266667 0 0 1-15.086667-6.246667l-42.666667-42.666666a21.333333 21.333333 0 0 1 30.173334-30.173334L362.666667 588.5l70.246666-70.253333a21.333333 21.333333 0 0 1 30.173334 30.173333l-85.333334 85.333333A21.266667 21.266667 0 0 1 362.666667 640z m384-42.666667H533.333333a21.333333 21.333333 0 0 1 0-42.666666h213.333334a21.333333 21.333333 0 0 1 0 42.666666zM362.666667 469.333333a21.266667 21.266667 0 0 1-15.086667-6.246666l-42.666667-42.666667a21.333333 21.333333 0 0 1 30.173334-30.173333L362.666667 417.833333l70.246666-70.253333a21.333333 21.333333 0 0 1 30.173334 30.173333l-85.333334 85.333334A21.266667 21.266667 0 0 1 362.666667 469.333333z m384-42.666666H533.333333a21.333333 21.333333 0 0 1 0-42.666667h213.333334a21.333333 21.333333 0 0 1 0 42.666667z m0-170.666667H320a21.333333 21.333333 0 0 1-21.333333-21.333333c0-26.046667 13.273333-50.786667 38.38-71.546667 19.54-16.153333 46.053333-29.666667 77.186666-39.38a129.22 129.22 0 0 1 41.453334-54.84 128 128 0 0 1 155.293333 0 129.22 129.22 0 0 1 41.453333 54.84c31.133333 9.713333 57.653333 23.226667 77.186667 39.38C754.726667 183.88 768 208.62 768 234.666667a21.333333 21.333333 0 0 1-21.333333 21.333333z m-398.38-42.666667h370.093333c-4.493333-6.926667-10.493333-12.82-15.953333-17.333333-17.166667-14.193333-42.14-26.066667-72.226667-34.32a21.333333 21.333333 0 0 1-14.853333-14.666667C604.893333 110.666667 571.166667 85.333333 533.333333 85.333333s-71.56 25.333333-82 61.673334a21.333333 21.333333 0 0 1-14.853333 14.666666c-30.1 8.26-55.073333 20.133333-72.24 34.326667-5.46 4.513333-11.46 10.406667-15.953333 17.333333z" fill="#8a8a8a" p-id="6328"></path></svg>
            新任务
            <a class="addTask" @click="openAddTasksModal('newTasks')">+</a>
          </h3>
          <div
          class="task"
            v-for="task in newTasks"
            :key="task.id"
            :style="{ borderLeft: '5px solid ' + task.color }"
            @click="openModal(task)"
          >
            {{ task.title }}
             </div>
          <a class="add-task-btn" @click="openAddTasksModal('newTasks')">+ New task</a>
        </div>

        
        <!-- 正在进行 -->

        <div class="task-column">
          <h3 class="column-title">
            <svg t="1716908597592" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="16042" width="200" height="200">
              <path d="M447.566769 223.100718a111.537231 111.537231 0 1 0 0-223.100718 111.537231 111.537231 0 0 0 0 223.100718z m-124.376615 450.612513a1437.669744 1437.669744 0 0 0-189.623795-78.637949 22.317949 22.317949 0 0 0-26.781538 15.622564C90.663385 672.059077 22.580513 896.787692 1.995487 970.988308a22.317949 22.317949 0 0 0 21.740308 28.435692H62.752821a21.740308 21.740308 0 0 0 20.637538-13.942154c22.843077-55.768615 89.796923-254.870974 99.826872-254.870974a167.332103 167.332103 0 0 1 136.612102 126.582154 310.534564 310.534564 0 0 1-40.146051 108.754051 22.869333 22.869333 0 0 0 19.534769 33.450667h45.161026a21.188923 21.188923 0 0 0 19.508513-11.132718 310.009436 310.009436 0 0 0 55.768615-136.086975 264.822154 264.822154 0 0 0-96.466051-178.46482z m683.191795 277.740307l-188.521026-357.481025c-30.667487-55.768615-94.785641-15.622564-125.453128 37.362872L610.986667 746.207179l-43.506872-41.24882a55.742359 55.742359 0 0 0 0-18.983385c-13.942154-80.869744-75.881026-357.481026-121.042051-402.090666l-4.988718-3.360821L301.42359 206.375385a42.430359 42.430359 0 0 0-23.420718-4.988718c-48.521846 0-160.059077 18.379487-195.741539 23.972102a23.446974 23.446974 0 0 0-16.200205 11.710359C54.377026 259.360821 22.055385 314.00041 3.675897 356.378256c-7.351795 16.856615-3.360821 36.49641 10.029949 49.099488l23.998359 19.508512L121.304615 489.682051c7.404308 5.77641 10.502564 15.517538 7.798154 24.523487-7.798154 23.420718 0 6.144-3.912205 17.302975a22.843077 22.843077 0 0 0 13.942154 26.781538c38.491897 13.915897 141.101949 68.004103 180.696615 79.163077 11.158974 2.783179 8.927179-8.349538 13.39077-18.957128l-4.46359-5.566359 245.943795 187.943385-98.146462 167.305846a22.317949 22.317949 0 0 0 19.534769 33.450666h481.28c18.484513 0.026256 33.476923-14.966154 33.50318-33.42441-0.026256-5.881436-1.575385-11.657846-4.516103-16.75159zM204.196103 316.914872a22.843077 22.843077 0 0 1-2.573129 9.373538v1.102769a583.627487 583.627487 0 0 0-33.476923 75.85477 22.317949 22.317949 0 0 1-36.233846 7.798154l-45.161026-41.826462A318.752821 318.752821 0 0 1 115.160615 304.574359a22.843077 22.843077 0 0 1 20.611282-11.710359h46.841436a22.843077 22.843077 0 0 1 21.556513 24.077128z m151.893333 227.433025l30.116102-74.200615a22.291692 22.291692 0 1 1 42.377847 0 1804.970667 1804.970667 0 0 0 61.912615 186.289231l-134.406564-112.114872z" fill="#FCDB00" p-id="16043"></path></svg>
            正在进行
            <a class="addTask" @click="openAddTasksModal('inProgressTasks')">+</a>
          </h3>
          <div
            class="task"
            v-for="task in inProgressTasks"
            :key="task.id"
            :style="{ borderLeft: '5px solid ' + task.color }"
            @click="openModal(task)"
          >
            {{ task.title }}
          </div>
          <a class="add-task-btn" @click="openAddTasksModal('inProgressTasks')">+ New task</a>

        </div>
        <!-- 完成 -->

        <div class="task-column">
          <h3 class="column-title"><svg t="1716908775367" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="18259" width="200" height="200">
            <path d="M511.950005 512.049995m-447.956254 0a447.956254 447.956254 0 1 0 895.912508 0 447.956254 447.956254 0 1 0-895.912508 0Z" fill="#20B759" p-id="18260"></path><path d="M458.95518 649.636559L289.271751 479.95313c-11.698858-11.698858-30.697002-11.698858-42.39586 0s-11.698858 30.697002 0 42.395859l169.683429 169.68343c11.698858 11.698858 30.697002 11.698858 42.39586 0 11.798848-11.598867 11.798848-30.597012 0-42.39586z" fill="#FFFFFF" p-id="18261"></path><path d="M777.62406 332.267552c-11.698858-11.698858-30.697002-11.698858-42.39586 0L424.158578 643.437164c-11.698858 11.698858-11.698858 30.697002 0 42.39586s30.697002 11.698858 42.39586 0l311.069622-311.069622c11.798848-11.798848 11.798848-30.796992 0-42.49585z" fill="#FFFFFF" p-id="18262"></path></svg>
            完成
            <a class="addTask" @click="openAddTasksModal('completedTasks')">+</a>
          </h3>
          <div
            class="task"
            v-for="task in completedTasks"
            :key="task.id"
            :style="{ borderLeft: '5px solid ' + task.color }"
            @click="openModal(task)"
          >
            {{ task.title }}
          </div>
          <a class="add-task-btn" @click="openAddTasksModal('completedTasks')">+ New task</a>

        </div>
        <!-- 废弃 -->

        <div class="task-column">
          <h3 class="column-title"><svg t="1716908657015" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="17249" width="200" height="200">
            <path d="M380.565633 84.168898C391.492953 73.241577 412.883938 64.383234 428.328892 64.383234L596.182087 64.383234C611.633685 64.383234 633.010015 73.233567 643.945345 84.168898L680.111776 120.335329 344.399202 120.335329 380.565633 84.168898Z" fill="#FC5143" p-id="17250"></path><path d="M875.944112 176.287425C891.394856 176.287425 903.92016 163.762122 903.92016 148.311377 903.92016 132.860633 891.394856 120.335329 875.944112 120.335329L148.566866 120.335329C133.116122 120.335329 120.590818 132.860633 120.590818 148.311377 120.590818 163.762122 133.116122 176.287425 148.566866 176.287425L875.944112 176.287425Z" fill="#FC5143" p-id="17251"></path><path d="M180.539492 232.239521 180.254748 228.253099 228.640985 176.287425 232.637564 176.287425 280.347765 844.230242C282.63628 876.269454 312.053012 903.664671 344.377659 903.664671L680.133319 903.664671C712.845805 903.664671 741.848496 876.636282 744.163214 844.230242L791.873414 176.287425 795.869993 176.287425 844.25623 228.253099 843.971486 232.239521 180.539492 232.239521ZM847.968064 176.287425 799.973118 848.216664C795.578506 909.741242 742.362215 959.616766 680.133319 959.616766L344.377659 959.616766C282.586578 959.616766 228.909839 909.424372 224.53786 848.216664L176.542914 176.287425 847.968064 176.287425Z" fill="#FC5143" p-id="17252"></path><path d="M484.279441 763.784431C484.279441 779.235176 496.804744 791.760479 512.255489 791.760479 527.706234 791.760479 540.231537 779.235176 540.231537 763.784431L540.231537 372.11976C540.231537 356.669016 527.706234 344.143713 512.255489 344.143713 496.804744 344.143713 484.279441 356.669016 484.279441 372.11976L484.279441 763.784431Z" fill="#FC5143" p-id="17253"></path><path d="M607.198225 760.600957C605.851604 775.992907 617.237593 789.562199 632.629543 790.908821 648.021493 792.255442 661.590785 780.869453 662.937406 765.477503L697.073232 375.303235C698.419853 359.911285 687.033864 346.341992 671.641914 344.995371 656.249965 343.64875 642.680672 355.034739 641.334051 370.426688L607.198225 760.600957Z" fill="#FC5143" p-id="17254"></path><path d="M361.573572 765.477503C362.920193 780.869453 376.489486 792.255442 391.881435 790.908821 407.273385 789.562199 418.659374 775.992907 417.312753 760.600957L383.176927 370.426688C381.830306 355.034739 368.261013 343.64875 352.869064 344.995371 337.477114 346.341992 326.091125 359.911285 327.437746 375.303235L361.573572 765.477503Z" fill="#FC5143" p-id="17255"></path></svg>
            废弃
            <a class="addTask">-</a>
          </h3>
          <div
            class="task"
            v-for="task in discardedTasks"
            :key="task.id"
            :style="{ borderLeft: '5px solid ' + task.color }"
            @click="openModal(task)"
          >
            {{ task.title }}
          </div>
        </div>
        
      </div>
      <div class="import-section">
        <img src="../../public/img/goal.png" alt="" class="import-image">
        

        <div class="import-message">
          
          <p>"The beautiful thing about learning is that nobody can take it away from you."</p>
          <p>"Live as if you were to die tomorrow. Learn as if you were to live forever."</p>
        </div>
      </div>
    </div>
  </div>

    <!-- TaskModal组件 -->
    <TaskModal 
      v-if="showModal" 
      :task="selectedTask" 
      @close="closeModal" 
      @save="updateTask" 
      @delete="deleteTask" 
    />
    <TaskModal v-if="showAddTaskModal" :show="showAddTaskModal" :task="newTask" @close="closeAddTaskModal" @save="addNewTask" />
</template>


<script setup>
import { ref } from 'vue';
import TaskModal from '../view/task.vue';

const showModal = ref(false);
const showAddTaskModal = ref(false);
const selectedTask = ref({});
const newTask = ref({ title: '', color: '#2081e2' });
const currentTaskList = ref('newTasks'); // 用于存储当前任务栏类型

const newTasks = ref([
  { id: 1, title: 'Learning SQL Basics', color: '#2081e2' },
  // 其他任务...
]);

const inProgressTasks = ref([
  { id: 2, title: 'Advanced Java Concepts', color: '#FCDB00' },
  { id: 3, title: 'bug review', color: '#FCDB00' },
  // 其他任务...
]);

const completedTasks = ref([
  { id: 4, title: 'Learn JS', color: '#20B759' },
  // 其他任务...
]);

const discardedTasks = ref([
  { id: 5, title: 'Learn c++', color: '#FC5143' },
  // 其他任务...
]);

const openModal = (task) => {
  selectedTask.value = { ...task };
  showModal.value = true;
};

const closeModal = () => {
  showModal.value = false;
};

const openAddTasksModal = (taskList) => {
  newTask.value = { id: Date.now(), title: '', color: '#2081e2' };
  currentTaskList.value = taskList;
  showAddTaskModal.value = true;
};

const closeAddTaskModal = () => {
  showAddTaskModal.value = false;
};

const addNewTask = (task) => {
  if (currentTaskList.value === 'newTasks') {
    newTasks.value.push(task);
  } else if (currentTaskList.value === 'inProgressTasks') {
    inProgressTasks.value.push(task);
  } else if (currentTaskList.value === 'completedTasks') {
    completedTasks.value.push(task);
  } else if (currentTaskList.value === 'discardedTasks') {
    discardedTasks.value.push(task);
  }
  closeAddTaskModal();
};

const updateTask = (updatedTask) => {
  const taskLists = [newTasks, inProgressTasks, completedTasks, discardedTasks];
  taskLists.forEach(taskList => {
    const taskIndex = taskList.value.findIndex(task => task.id === selectedTask.value.id);
    if (taskIndex !== -1) {
      taskList.value[taskIndex] = { ...taskList.value[taskIndex], ...updatedTask };
    }
  });
  closeModal();
};

const deleteTask = (taskToDelete) => {
  const taskLists = [newTasks, inProgressTasks, completedTasks];
  let taskFound = false;

  taskLists.forEach(taskList => {
    const taskIndex = taskList.value.findIndex(task => task.id === taskToDelete.id);
    if (taskIndex !== -1) {
      const task = taskList.value.splice(taskIndex, 1)[0];
      discardedTasks.value.push(task);
      taskFound = true;
    }
  });

  if (!taskFound) {
    const taskIndex = discardedTasks.value.findIndex(task => task.id === taskToDelete.id);
    if (taskIndex !== -1) {
      discardedTasks.value.splice(taskIndex, 1);
    }
  }

  closeModal();
};

</script>


<style scoped>
html, body {
  margin: 0;
  padding: 0;
  height: 100%;
  background-color: #f4f4f9; /* 原来的背景颜色 */
}

.outer-container {
  padding: 20px 20px 0 20px;
  height: 90%;
  box-sizing: border-box;
  background-color: #f4f4f9;
}

.goals-container {
  position: relative;
  z-index: 1;
  padding: 20px;
  background-color: white;
  height: 100%;
  border-radius: 10px; /* 可选，添加圆角使其更加美观 */
  box-shadow: 0 1px 3px rgba(0, 0, 0, 0.1); /* 可选，添加阴影效果 */
}

.goals-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 20px;
}

.new-task-btn {
  background-color: #2081e2;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 16px;
}

.goals-board {
  display: flex;
  gap: 20px;
}

.task-column {
  flex: 1;
  padding: 10px;
  border-radius: 5px;
  display: flex;
  flex-direction: column;
  background-color: white;
}

.column-title {
  margin-bottom: 10px;
  font-size: 18px;
  color: #666;
}

.task {
  background-color: white;
  padding: 10px;
  border-radius: 5px;
  margin-bottom: 10px;
  font-size: 16px;
  color: #333;
  box-shadow: 2px 2px 5px rgba(0, 0, 0, 0.3); /* 修改阴影，增加模糊半径 */
  border-left: 5px solid #2081e2; /* 左侧颜色条 */
  height: 45px;
  align-content: center;
  cursor: pointer;
}

.add-task-btn {
  color: rgb(155, 144, 160);
  cursor: pointer;
  text-align: left;

  font-size: 16px;
  padding: 10px;

  
}
.add-task-btn:hover{
  background-color: rgb(161, 202, 252);

  border-radius: 5px;
  margin-bottom: 10px;
  font-size: 16px;
  color: rgb(51, 124, 241);

}
.import-section {
  position: fixed;
  bottom: 70px;
  left: 50%;
  transform: translateX(-50%);
  z-index: -1; /* 确保它在较低的图层 */
  width: 70%; /* 根据需要调整宽度 */
  padding: 20px;
  border-radius: 5px;
  background-color: white;
}

.import-message {
  margin-top: 50px;

  text-align: center;
}

.import-message p {
  color: rgb(155, 144, 160);
}


.icon{
  width: 24px;
  height: 24px;
  margin-left: 10px;
  margin-right: 5px;

}
.addTask{
  cursor: pointer;
  float: right;
  margin-right: 10px;

  font-size: 25px;
}
.import-image {
  width: 300px; /* 调整宽度 */
  height: auto; /* 自动调整高度以保持比例 */
  display: block;
  
  margin: 0 auto 30px; /* 居中对齐并添加底部间距 */
}

</style>
