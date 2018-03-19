<template>
  <table>
    <tr>
      <th>ID</th>
      <th>NAME</th>
      <th @click="sortBy('Business')" :class="{ active: sortKey == 'Business' }"
      >BUSINESS</th>
      <th>POSITION</th>
    </tr>
    <tr
      v-for="member in filteredData"
      v-bind:key="member">
      <td>{{member.m_id}}</td>
      <td>{{member.m_name}}</td>
      <td>{{member.m_business}}</td>
      <td>{{member.m_position}}</td>
    </tr>
  </table>
</template>

<script>
import axios from 'axios'

export default {
  data () {
    return {
      members: [],
      sortKey: ''
    }
  },

  created () {
    axios.get(`/member`).then(response => {
      console.log(`response : ` + response.data)
      this.members = response.data
    }).catch(e => {
      this.errors.push(e)
    })
  },

  computed: {
    filteredData: function () {
      var sortKey = this.sortKey
      var data = this.members

      if (sortKey) {
        data = data.slice().sort(function (a, b) {
          a = a.sortKey
          b = b.sortKey
          return (a === b ? 0 : a > b ? 1 : -1) * 1
        })
      }

      return data
    }
  },
  methods: {
    sortBy: function (key) {
      console.log(`key : ` + key)
      if (key === `Business`) this.sortKey = `m_business`
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
body {
  font-family: Helvetica Neue, Arial, sans-serif;
  font-size: 14px;
  color: #444;
}

table {
  border: 2px solid #42b983;
  border-radius: 3px;
  background-color: #fff;
}

th {
  background-color: #42b983;
  color: rgba(255,255,255,0.66);
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

td {
  background-color: #f9f9f9;
}

th, td {
  min-width: 120px;
  padding: 10px 20px;
}


th.active {
  color: #fff;
}

th.active .arrow {
  opacity: 1;
}

.arrow {
  display: inline-block;
  vertical-align: middle;
  width: 0;
  height: 0;
  margin-left: 5px;
  opacity: 0.66;
}

.arrow.asc {
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  border-bottom: 4px solid #fff;
}

.arrow.dsc {
  border-left: 4px solid transparent;
  border-right: 4px solid transparent;
  border-top: 4px solid #fff;
}
</style>
