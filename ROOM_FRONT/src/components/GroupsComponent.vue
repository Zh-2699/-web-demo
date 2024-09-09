<template>
  <div class="container">
    <!-- 群组选择侧边栏 -->
    <aside class="group-sidebar">
      <div class="group-header">群组</div>
      <div
        class="group-item"
        v-for="(group, index) in groups"
        :key="index"
        :class="{ active: selectedGroup === index }"
        @click="selectGroup(index)"
      >
        <img :src="group.icon" alt="Group Icon" class="group-avatar">
        <span class="group-name">{{ group.name }}</span>
      </div>
      <!-- 可以添加更多群组 -->
      <div class="group-item add-group" @click="addGroup">
        <span>新建群组+</span>
      </div>
    </aside>

    <!-- 主内容区域 -->
    <div class="content-container">
      <!-- 频道选择侧边栏 -->

      <!-- 主内容 -->
      <main class="main-content">
        <header class="header">
          <span class="channel-name"># {{ groups[selectedGroup].name }}</span>
          <div class="header-icons">
            <i class="fas fa-bell"></i>
            <i class="fas fa-thumbtack"></i>
            <i class="fas fa-user-friends"></i>
            <i class="fas fa-search"></i>
          </div>
        </header>
        
        <div v-if="!hasMessages" class="welcome-section">
          <!-- 主要内容区域 -->
          <div class="welcome-content">
            <h2>欢迎来到 Learntrack</h2>
            <p>这是您首次访问，崭新的服务器。请在这里查看入门步骤，帮助您起步！欲知更多信息，请参阅我们的入门指南。</p>
            <div class="action-list">
              <div class="action-item">
                <i class="fas fa-user-plus"></i>
                <span>邀请您的好友</span>
              </div>
              <div class="action-item">
                <i class="fas fa-paint-brush"></i>
                <span>用图标个性化</span>
              </div>
              <div class="action-item">
                <i class="fas fa-comment-dots"></i>
                <span>发送第一条消息</span>
              </div>
              <div class="action-item">
                <i class="fas fa-download"></i>
                <span>加入群组</span>
              </div>
            </div>
          </div>
        </div>
        
        <div v-else class="chat-section">
          <div class="chat-messages">
            <div v-for="(message, index) in messages[selectedGroup]" :key="index" class="message">
              <img src="../../public/img/4.png" alt="Avatar" class="avatar">
              <div class="message-content">
                {{ message }}
              </div>
            </div>
          </div>
        </div>
        
        <div class="input-container">
          <inputContainer @send-message="handleMessage"/>
        </div>
      </main>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, watch } from 'vue';
import inputContainer from '../view/input.vue';

const groups = ref([
  { name: '群组一', icon: '../../public/img/5.png' },
  { name: '群组二', icon: '../../public/img/6.png' },
  { name: '群组三', icon: '../../public/img/7.png' },
]);

const messages = ref({});
const hasMessages = ref(false);
const selectedGroup = ref(0);

const loadMessages = () => {
  const savedMessages = localStorage.getItem('chatMessages');
  if (savedMessages) {
    messages.value = JSON.parse(savedMessages);
  } else {
    // 初始化每个群组的消息数组
    groups.value.forEach((group, index) => {
      messages.value[index] = [];
    });
  }
  // 确保每个群组都有一个初始化的消息数组
  groups.value.forEach((group, index) => {
    if (!Array.isArray(messages.value[index])) {
      messages.value[index] = [];
    }
  });
  hasMessages.value = messages.value[selectedGroup.value]?.length > 0;
};

const saveMessages = () => {
  localStorage.setItem('chatMessages', JSON.stringify(messages.value));
};

const handleMessage = (message) => {
  if (!Array.isArray(messages.value[selectedGroup.value])) {
    messages.value[selectedGroup.value] = [];
  }
  messages.value[selectedGroup.value].push(message);
  hasMessages.value = true;
  saveMessages();
};

const selectGroup = (index) => {
  selectedGroup.value = index;
  hasMessages.value = messages.value[index]?.length > 0;
};

const addGroup = () => {
  const newGroup = { name: `群组${groups.value.length + 1}`, icon: '../../public/img/3.png' };
  groups.value.push(newGroup);
  messages.value[groups.value.length - 1] = [];
  saveMessages();
};

onMounted(() => {
  loadMessages();
});

watch(selectedGroup, (newVal) => {
  hasMessages.value = messages.value[newVal]?.length > 0;
});
</script>

<style scoped>
/* 保留现有样式 */
html {
  background-color: #007bff;
}

.container {
  display: flex;
  height: 100vh;
  background-color: #f4f4f9;
  overflow: hidden;
}

.group-sidebar {
  width: 250px;
  background-color: #f4f4f9;
  display: flex;
  flex-direction: column;
  align-items: center;

}

.group-item {
  width: 70%;
  height: 60px;
  margin-bottom: 10px;
  display: flex;
  align-items: center;
  cursor: pointer;
  background-color: #fff;
  border-radius: 10px;
  transition: background-color 0.3s;
  padding: 5px 10px;
  box-sizing: border-box;
}

.group-item.active {
  background-color: #e0e0e0;
}

.group-avatar {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  margin-right: 10px;
}

.group-name {
  color: #6c757d;
  font-size: 16px;
  flex-grow: 1;
}

.group-item:hover {
  background-color: #dce0e3;
}

.add-group {
  font-size: 20px;
  color: #007bff;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #fff;
  border: 2px dashed #007bff;
  width: 70%;
  height: 60px;
  transition: background-color 0.3s, color 0.3s;
}

.add-group:hover {
  background-color: #007bff;
  color: #fff;
}

.content-container {
  display: flex;
  flex-direction: column;
  flex: 1;
  background-color: #fff;
}

.sidebar {
  width: 240px;
  background-color: #fff;
  padding: 20px;
  color: #6c757d;
  display: flex;
  flex-direction: column;
  align-items: center;
  border-right: 1px solid #ccc;
}

.server-icon img {
  width: 50px;
  height: 50px;
  margin-bottom: 20px;
}

.channel-list {
  width: 100%;
  list-style: none;
  padding: 0;
  margin: 0;
}

.channel-item {
  width: 100%;
  padding: 10px;
  margin-bottom: 10px;
  background-color: #f4f4f9;
  border-radius: 5px;
  text-align: center;
  cursor: pointer;
  transition: background-color 0.3s;
}

.channel-item:hover {
  background-color: #e0e0e0;
}

.main-content {
  flex: 1;
  display: flex;
  flex-direction: column;
  background-color: #fff;
  color: #6c757d;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 10px 20px;
  background-color: #fff;
  color: #6c757d;
  border-bottom: 1px solid #ccc;
}

.header .channel-name {
  font-size: 18px;
  font-weight: bold;
}

.header .header-icons i {
  margin-left: 10px;
  cursor: pointer;
}

.welcome-section {
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  text-align: center;
  margin: 20px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
}

.welcome-content {
  flex: 1;
  width: 50%;
}

.welcome-section h2 {
  margin-top: 0;
}

.action-list {
  margin-top: 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.action-item {
  display: flex;
  align-items: center;
  padding: 15px 20px;
  background-color: #f4f4f9;
  border-radius: 5px;
  cursor: pointer;
  width: 300px;
  margin-bottom: 10px;
  transition: background-color 0.3s;
}

.action-item:hover {
  background-color: #e0e0e0;
}

.action-item i {
  margin-right: 10px;
  font-size: 20px;
}

.chat-section {
  display: flex;
  flex-direction: column;
  flex: 1;
  width: 100%;
  padding: 20px;
  overflow-y: auto;
}

.chat-messages {
  flex: 1;
  display: flex;
  flex-direction: column;
  gap: 10px;
}

.message {
  display: flex;
  align-items: flex-start;
  gap: 10px;
  padding: 10px;
  background-color: #e9ecef;
  border-radius: 10px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  transition: background-color 0.3s;
  width: 96%;
}

.message:hover {
  background-color: #dce0e3;
}

.message-content {
  max-width: 70%;
  word-wrap: break-word;
}

.avatar {
  width: 40px;
  height: 40px;
  border-radius: 50%;
}

.input-container {
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 20px;
  background-color: #fff;
  border-top: 1px solid #ccc;
}

.group-header {
  border-radius: 10px;
  font-size: 24px;
  color: grey;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #fff;
  margin-bottom: 10px;
  width: 100%;
  height: 60px;
}
</style>
