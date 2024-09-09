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
        <div class="profile-section">
          <div class="profile">
            <img src="../../public/img/3.png" alt="Profile Picture" @error="handleImageError">
            <span class="name">User Name</span>
          </div>
          <button class="logout-btn" :class="{ 'centered': !isExpanded }" @click="logout">
            <i class="fas fa-sign-out-alt"></i>
            <span v-if="isExpanded">Logout</span>
          </button>
        </div>
      </aside>
  
      <!-- 主内容区域 -->
      <!-- <main class="main-content" @click="collapseSidebar">
        <header class="main-header">
          <h1>Company Resources</h1>
          <input type="text" placeholder="Search Chrome, Drive, Workona, & more">
          <button class="new-doc-btn">NEW DOC</button>
        </header>
        <section class="content-section">
          <div class="content-header">
            <h2>Benefits</h2>
            <button class="add-resource-btn">+</button>
          </div>
          <ul class="content-list">
            <li v-for="(item, index) in benefits" :key="index">
              <i class="fas fa-file-alt"></i> {{ item }}
            </li>
          </ul>
          <div class="content-header">
            <h2>Culture</h2>
            <button class="add-resource-btn">+</button>
          </div>
          <ul class="content-list">
            <li v-for="(item, index) in culture" :key="index">
              <i class="fas fa-file-alt"></i> {{ item }}
            </li>
          </ul>
        </section>
      </main> -->
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  
  const isExpanded = ref(false);
  const activeIndex = ref(0); // Initialize activeIndex to 0 for the "Home" button to be selected
  const navItems = [
    { icon: 'fas fa-house', tooltip: '主页'},
    { icon: 'fas fa-users', tooltip: '好友' },
    { icon: 'fas fa-paper-plane', tooltip: '群组' },
    { icon: 'fas fa-bullseye', tooltip: '目标' },
    { icon: 'fas fa-check', tooltip: '打卡' },
    { icon: 'fas fa-heart', tooltip: 'Likes' }
  ];
  const benefits = ref(['401(k) Match Details', 'Request Time Off', 'Submit Reimbursement', 'Company Holidays']);
  const culture = ref(['Welcome Video', 'Employee Onboarding Guide', 'Company Org Chart', 'Technical Documentation']);
  
  const toggleSidebar = () => {
    isExpanded.value = !isExpanded.value;
  };
  
  const collapseSidebar = () => {
    if (isExpanded.value) {
      isExpanded.value = false;
    }
  };
  
  const setActive = (index) => {
    if (!isExpanded.value) {
      isExpanded.value = true;
    }
    activeIndex.value = index;
  };
  
  const showAuthor = () => {
    alert("Fu Daheng");
  };
  
  const handleImageError = (event) => {
    event.target.src = "../../public/img/fallback.png"; // 替代图片的路径
  };
  
  const logout = () => {
    alert('Logged out');
  };
  </script>
  
  <style scoped>
  body {
    margin: 0;
    font-family: 'Open Sans', sans-serif;
    background-color: #f4f4f9;
    display: flex;
    height: 100vh;
    overflow: hidden;
  }
  
  .container {
    display: flex;
    width: 100%;
  }
  
  .sidebar {
    width: 80px;
    background-color: #fff;
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 10px 0;
    transition: width 0.4s ease-in-out;
    box-shadow: 2px 0 5px rgba(0, 0, 0, 0.1);
    border-radius: 20px;
    color: #6c757d;
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
  
  .sidebar.expanded {
    width: 180px;
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
  }
  
  .profile img {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    margin-right: 10px;
    cursor: pointer;
  }
  
  .profile .name {
    display: none;
    font-size: 16px;
  }
  
  .sidebar.expanded .profile .name {
    display: block;
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
    padding: 20px;
    background-color: #f4f4f9;
  }
  
  .main-content h1 {
    margin-top: 0;
    font-size: 24px;
  }
  
  .main-header {
    display: flex;
    align-items: center;
    justify-content: space-between;
    background-color: #fff;
    padding: 10px;
    border-bottom: 1px solid #ddd;
  }
  
  .main-header input {
    flex: 1;
    padding: 10px;
    margin: 0 20px;
    border: 1px solid #ddd;
    border-radius: 5px;
    font-size: 14px;
  }
  
  .new-doc-btn {
    background-color: #007bff;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
    font-size: 14px;
  }
  
  .content-section {
    flex: 1;
    padding: 20px;
    background-color: #fff;
    margin-top: 20px;
    border-radius: 10px;
    box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
  }
  
  .content-header {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-bottom: 10px;
  }
  
  .add-resource-btn {
    background-color: #007bff;
    color: white;
    border: none;
    padding: 5px 10px;
    border-radius: 50%;
    cursor: pointer;
    font-size: 16px;
  }
  
  .content-list {
    list-style: none;
    padding: 0;
    margin: 0;
  }
  
  .content-list li {
    display: flex;
    align-items: center;
    padding: 10px 0;
    border-bottom: 1px solid #ddd;
    font-size: 16px;
  }
  
  .content-list li i {
    margin-right: 10px;
    font-size: 18px;
  }
  
  @media (max-width: 768px) {
    .container {
      flex-direction: column;
    }
  
    .sidebar {
      width: 100%;
      height: auto;
    }
  
    .main-header input {
      margin: 10px 0;
    }
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
  </style>
  