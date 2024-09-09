<template>
  <div class="container">
    <!-- 侧边栏 -->
    <aside class="sidebar" :class="{ expanded: isExpanded }" @click.stop="toggleSidebar">
      <div class="logo" @click="toggleSidebar">
        <img src="../../public/img/2.png" alt="Logo" @click="showAuthor" @error="handleImageError">
        <span class="logo-text">Learntrack</span>
      </div>
      <nav class="nav-menu">
        <ul>
          <li class="nav-item" v-for="(item, index) in navItems" :key="index">
            <a href="#" class="nav-link" :class="{ active: activeIndex === index }" @click.stop="setActive(index)">
              <i :class="item.icon"></i>
              <span class="tooltip">{{ item.tooltip }}</span>
            </a>
          </li>
        </ul>
        <hr class="separator">
      </nav>

      <!-- 用户信息  -->
      <div class="profile-section" @click.stop>
        <div class="profile" @click="handleProfileClick">
          <img :src="isLoggedIn ? '../../public/img/4.png' : '../../public/img/3.png'" alt="Profile Picture" @error="handleImageError">
          <div class="profile-info">
            <span class="name">{{ userProfile.userName || '请登录' }}</span>
            <span class="email">{{ userProfile.email }}</span>
          </div>
        </div>
        <button class="logout-btn" :class="{ 'centered': !isExpanded }" @click="logout">
          <i class="fas fa-sign-out-alt" style="color: rgba(45, 12, 12, 0.897);"></i>
          <span v-if="isExpanded" style="color: rgba(45, 12, 12, 0.897);">Logout</span>
        </button>
      </div>
    </aside>

    <!-- 主内容区域 -->
    <main class="main-content" @click="collapseSidebar">
      <component :is="currentComponent" />
    </main>

    <!-- 侧边菜单 -->
    <transition name="slide-right">
      <div v-if="showProfileMenu" class="side-menu" :style="{ right: '0' }">
        <ProfileComponent :userProfile="userProfile" @close="closeProfileMenu" />
      </div>
    </transition>

    <!-- 弹出对话框 -->
    <div v-if="showPopup" class="popup-overlay" @click="closePopup">
      <div class="popup-content" @click.stop>
        <component 
          :is="popupComponent" 
          @close="closePopup" 
          @switchToRegister="switchToRegister" 
          @switchToLogin="switchToLogin"
          @loginSuccess="handleLoginSuccess"
        />
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';

// 导入动态组件
import HomeComponent from './components/HomeComponent.vue';
import FriendsComponent from './components/FriendComponent.vue';
import GroupsComponent from './components/GroupsComponent.vue';
import GoalsComponent from './components/GoalsComponent.vue';
import CheckinComponent from './components/CheckinComponent.vue';
import LikesComponent from './components/LikesComponent.vue';
import ProfileComponent from './view/ProfileComponent.vue';
import LoginComponent from './view/LoginComponent.vue';
import RegisterComponent from './view/RegisterComponent.vue';

const isExpanded = ref(false);
const activeIndex = ref(0);
const showPopup = ref(false);
const showProfileMenu = ref(false);
const popupComponent = ref(null);
const isLoggedIn = ref(false); // 模拟用户登录状态
const userProfile = ref({}); // 用于存储用户信息

const navItems = [
  { icon: 'fas fa-house', tooltip: '主页' },
  { icon: 'fas fa-users', tooltip: '好友' },
  { icon: 'fas fa-paper-plane', tooltip: '群组' },
  { icon: 'fas fa-bullseye', tooltip: '目标' },
  { icon: 'fas fa-check', tooltip: '打卡' },
  { icon: 'fas fa-heart', tooltip: 'Likes' }
];

const currentComponent = ref(HomeComponent); // 默认组件

const toggleSidebar = () => {
  isExpanded.value = !isExpanded.value;
};

const collapseSidebar = () => {
  if (isExpanded.value) {
    isExpanded.value = false;
  }
};

const setActive = (index) => {
  activeIndex.value = index;
  switch (index) {
    case 0:
      currentComponent.value = HomeComponent;
      break;
    case 1:
      currentComponent.value = FriendsComponent;
      break;
    case 2:
      currentComponent.value = GroupsComponent;
      break;
    case 3:
      currentComponent.value = GoalsComponent;
      break;
    case 4:
      currentComponent.value = CheckinComponent;
      break;
    case 5:
      currentComponent.value = LikesComponent;
      break;
  }
};

const showAuthor = () => {
  alert("Fu Daheng");
};

const handleImageError = (event) => {
  event.target.src = "/img/3.png"; // 替代图片的路径
};

const logout = () => {
  localStorage.removeItem('authToken'); // 移除令牌
  isLoggedIn.value = false; // 设置用户为未登录状态
  userProfile.value = {}; // 清空用户信息
  alert('Logged out');
};

const handleProfileClick = () => {
  if (isLoggedIn.value) {
    showProfileMenu.value = true;
  } else {
    popupComponent.value = LoginComponent;
    showPopup.value = true;
  }
};

const closePopup = () => {
  showPopup.value = false;
};

const closeProfileMenu = () => {
  showProfileMenu.value = false;
};

const switchToRegister = () => {
  popupComponent.value = RegisterComponent;
};

const switchToLogin = () => {
  popupComponent.value = LoginComponent;
};

const handleLoginSuccess = (username) => {
  isLoggedIn.value = true; // 设置用户为已登录状态
  fetchUserProfile(username); // 获取用户信息
  closePopup(); // 关闭对话框
};

const fetchUserProfile = (username) => {
  const token = localStorage.getItem('authToken');
  if (token) {
    axios.post('http://localhost:8080/user/search_friend', {
      userName: username
    }, {
      headers: {
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/json'
      }
    })
    .then(response => {
      if (response.data.code === 200) {
        userProfile.value = response.data.data; // 存储用户信息
        console.log(userProfile.value)
      } else {
        console.error('获取用户信息失败:', response.data.message);
      }
    })
    .catch(error => {
      console.error('请求失败:', error);
    });
  }
};
</script>

<style scoped>
html, body, #app {
  height: 100%;
  margin: 0;
  padding: 0;
  font-family: 'Open Sans', sans-serif;
}

body {
  background-color: #f4f4f9;
  display: flex;
  overflow: hidden;
}

.container {
  display: flex;
  width: 100%;
  height: 100%;
}

/* 优化侧边栏动画 */
.sidebar {
  width: 80px;
  background-color: #fff;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 10px 0;
  transition: width 0.6s cubic-bezier(0.4, 0.0, 0.2, 1); /* 调整持续时间和缓动函数 */
  box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
  border-radius: 20px;
  color: #6c757d;
}

.sidebar.expanded {
  width: 180px;
}

.logo {
  display: flex;
  align-items: center;
  margin-bottom: 20px;
  cursor: pointer;
}

.logo img {
  width: 40px;
  height: 40px;
}

.logo .logo-text {
  display: none;
  font-size: 18px;
  font-weight: bold;
  margin-left: 10px;
}

.sidebar.expanded .logo .logo-text {
  display: inline;
}

.nav-menu {
  flex: 1;
  width: 100%;
}

.nav-menu ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.nav-menu .nav-item {
  width: 100%;
  text-align: center;
}

.nav-menu .nav-item a {
  display: flex;
  align-items: center;
  padding: 15px;
  text-decoration: none;
  color: #6c757d;
  width: 100%;
  transition: background-color 0.3s, color 0.3s, border-radius 0.3s, width 0.3s ease-in-out;
  margin-left: 10px;
  font-size: 16px;
  border-radius: 10px;
}

.nav-menu .nav-item a:hover {
  width: 130px;
  background-color: rgb(32, 129, 226);
  color: white;
  border-radius: 10px;
}

.nav-menu .nav-item a.active {
  background-color: rgb(32, 129, 226);
  color: white;
  border-radius: 10px;
  width: 130px;
}

.nav-menu .nav-item a i {
  font-size: 24px;
  transition: margin-right 0.3s;
}

.nav-menu .nav-item a .tooltip {
  display: none;
  font-size: 16px;
  margin-left: 10px;
}

.sidebar.expanded .nav-menu .nav-item a {
  justify-content: flex-start;
}

.sidebar.expanded .nav-menu .nav-item a i {
  margin-right: 10px;
}

.sidebar.expanded .nav-menu .nav-item a .tooltip {
  display: inline;
}

.profile-section {
  padding: 20px 0;
  text-align: center;
  width: 100%;
}

.profile {
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  flex-direction: column; /* 修改此行，使用户名和邮箱垂直排列 */
}

.profile img {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  margin-bottom: 10px; /* 调整为下方间距 */
  cursor: pointer;
}

.profile-info {
  display: flex;
  flex-direction: column;
  align-items: center;
}

.name, .email {
  display: block;
  font-size: 16px;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  max-width: 100%;
}

.email {
  display: none; /* 默认隐藏邮箱 */
  font-size: 14px;
  color: #6c757d;
}

.sidebar.expanded .email {
  display: block; /* 侧边栏展开时显示邮箱 */
}

.sidebar.expanded .profile-info {
  width: 100px; /* 设置宽度，使省略号生效 */
  text-align: center;
}

.sidebar.expanded .profile-info .name, .sidebar.expanded .profile-info .email {
  max-width: 100%; /* 设定最大宽度 */
}

.logout-btn {
  background: none;
  border: none;
  color: #6c757d;
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 15px;
  width: 100%;
  transition: all 0.3s;
  font-size: 16px;
}

.logout-btn i {
  margin-right: 10px;
}

.sidebar.expanded .logout-btn {
  justify-content: center;
}

.sidebar.expanded .logout-btn i {
  margin-right: 10px;
}

.sidebar.expanded .logout-btn span {
  display: block;
}

.main-content {
  flex-grow: 1;
  background-color: #f4f4f9;
  height: 100%;
}

.separator {
  border: 0;
  height: 1px;
  background: #ccc;
  margin: 20px 0;
  width: 80%;
  margin-top: 100px;
  margin-left: auto;
  margin-right: auto;
}

.side-menu {
  position: fixed;
  right: -300px; /* 初始位置在屏幕外 */
  top: 50px; /* 距离顶部 50px */
  bottom: 300px; /* 距离底部 50px */
  background-color: #06283D;
  color: #fff;
  box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
  z-index: 1000;
  display: flex;
  align-items: center;
  justify-content: center;
  transition: transform 0.5s ease, right 0.5s cubic-bezier(0.4, 0.0, 0.2, 1); /* 添加动画效果 */
  width: 300px;
  height: 50%;
}

.slide-right-enter-active, .slide-right-leave-active {
  transition: transform 0.5s ease;
}

.slide-right-enter, .slide-right-leave-to {
  transform: translateX(300px); /* 定义进入和离开的动画效果 */
}

.popup-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 1000;
}

.popup-content {
  background-color: #fff;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
  position: relative;
  max-width: 500px;
  width: 100%;
  display: flex;
  align-content: center;
  justify-content: center;
}

</style>
