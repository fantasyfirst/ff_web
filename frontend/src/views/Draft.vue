<template>
  <div class="main">
    <b-container class="mt-3">
      <b-alert show variant="info"><em>EricKline is up!</em></b-alert>
      <b-row>
        <b-col>
          <b-table striped hover :items="items" />
        </b-col>
        <b-col>
          <h2>Teams Left</h2>
          <b-list-group>
            <b-list-group-item v-for="team in teams" :key="team"><b-row><b-col>{{team}}</b-col><b-col><b-button size="sm" variant="outline-dark" disabled>select</b-button></b-col></b-row></b-list-group-item>
          </b-list-group>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
export default {
  name: "home",
  data() {
    return {
      teams: [27,254,45],
      items: [{
          player: "EricKline",
          "team 1": "9:30pm",
          "team 2": "9:57pm",
          "team 3": "9:59pm",
          status : "live picking - online"
        },
        {
          player: "Miklast",
          "team 1": "9:33pm",
          "team 2": "9:55pm",
          "team 3": "10:01pm",
          status : "live picking - online"
        },
        {
          player: "Darre",
          "team 1": "9:36pm",
          "team 2": "9:53pm",
          "team 3": "10:03pm",
          status : "live picking - online"
        },
        {
          player: "Clayton Yocom",
          "team 1": "9:39pm",
          "team 2": "9:51pm",
          "team 3": "10:05pm",
          status : "live picking - online"
        },
        {
          player: "CBrosch0",
          "team 1": "9:42pm",
          "team 2": "9:49pm",
          "team 3": "10:07pm",
          status : "live picking - online"
        },
        {
          player: "Akod",
          "team 1": "9:45pm",
          "team 2": "9:47pm",
          "team 3": "10:09pm",
          status : "live picking - online"
        }]
    }
  }
};
</script>
