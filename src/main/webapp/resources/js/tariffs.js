Vue.component("carousel", {
  template: "#v-carousel",
  data() {
    return {
      currentOffset: 0,
      windowSize: 3,
      paginationFactor: 220,
      items: [
        {name: 'Tariff 1', tag: ["cool tariff"]},
        {name: 'Tariff 2', tag: ["cool tariff"]},
        {name: 'Tariff 3', tag: ["cool tariff"]},
        {name: 'Tariff 4', tag: ["cool tariff"]},
        {name: 'Tariff 5', tag: ["cool tariff"]},
        {name: 'Tariff 6', tag: ["cool tariff"]},
        {name: 'Tariff 7', tag: ["cool tariff"]},
      ]
    }
  },
  computed: {
    atEndOfList() {
      return this.currentOffset <= (this.paginationFactor * -1) * (this.items.length - this.windowSize);
    },
    atHeadOfList() {
      return this.currentOffset === 0;
    },
  },
  methods: {
    moveCarousel(direction) {
      // Find a more elegant way to express the :style. consider using props to make it truly generic
      if (direction === 1 && !this.atEndOfList) {
        this.currentOffset -= this.paginationFactor;
      } else if (direction === -1 && !this.atHeadOfList) {
        this.currentOffset += this.paginationFactor;
      }
    },
  }
});

new Vue({
  el:"#app"
});