<template>
  <div class="profile-container">
    <Setting></Setting>
    <button class="close-button" @click="$emit('close')">×</button>
    <div class="profile-header">
      <img class="avatar" :src="avatarUrl" alt="Avatar">
      <h2 class="username">{{ userProfile.userName }}</h2>
    </div>
    <hr>
    <div class="profile-details">
      <div class="detail-item">
        <span class="label">邮箱</span>
        <span class="value">{{ userProfile.email }}</span>
      </div>
      <div class="detail-item">
        <span class="label">电话号码</span>
        <span class="value">{{ userProfile.phoneNumber || '无' }}</span>
      </div>
      <div class="detail-item">
        <span class="label">年级</span>
        <span class="value">23届毕业生</span>
      </div>
    </div>
    <hr>
    <div class="footer">
      <div class="setting">
        <Setting style="display: none;"></Setting>
      </div>
      <Logout @click="show" />
    </div>
  </div>
</template>

<script setup>
import { defineProps, computed } from 'vue';
import Logout from './Logout.vue';
import Setting from './Setting.vue';

const props = defineProps({
  userProfile: {
    type: Object,
    default: () => ({})
  }
});

const avatarUrl = computed(() => props.userProfile.picture 
  ? `data:image/png;base64,${props.userProfile.picture}` 
  : '/img/4.png');

  console.log(avatarUrl.value);

const show = () => {
  console.log(props.userProfile.value);
}
</script>

<style scoped>
.profile-container {
  background-color: #06283D;
  color: #fff;
  padding: 20px;
  border-radius: 10px;
  text-align: center;
  width: 100%;
  height: 100%;
  position: relative;
  display: flex;
  flex-direction: column;
}

.close-button {
  position: absolute;
  top: 10px;
  right: 10px;
  background: none;
  border: none;
  font-size: 24px;
  color: #fff;
  cursor: pointer;
}

.profile-header {
  margin-top: 0px;
  margin-bottom: 50px;
}

.avatar {
  width: 90px;
  height: 90px;
  border-radius: 50%;
  margin-bottom: 10px;
}

.username {
  font-size: 22px;
  margin-bottom: 5px;
}

.profile-details {
  margin-top: 20px;
  margin-bottom: 20px;
  text-align: left;
  color: #fff;
}

.detail-item {
  display: flex;
  justify-content: space-between;
  margin: 5px 0;
}

.label {
  font-weight: bold;
  color: #fff;
}

.contact-button {
  background-color: #ff6f61;
  color: #fff;
  padding: 10px 20px;
  border: none;
  border-radius: 20px;
  cursor: pointer;
  transition: background-color 0.3s;
}

.contact-button:hover {
  background-color: #ff5a4c;
}

.footer {
  display: flex;
  text-align: center;
  margin-top: 50px;
  justify-content: space-between;
  padding: 0 20px;
}

.setting {
  margin-bottom: 10px;
}

hr {
  border: none;
  border-top: 1px solid #fff;
  margin: 10px 0;
}
</style>
