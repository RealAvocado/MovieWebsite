<template>
  <b-button variant="light" :class="{ active: isActive }" @click="pressBtn">{{ text }}</b-button>
</template>

<script>
export default {
  data () {
    return {
      isActive: false
    }
  },
  props: {
    text: String
  },
  methods: {
    pressBtn () {
      this.isActive = !this.isActive
      this.$emit('clickbtn')
    }
  }
}
</script>
