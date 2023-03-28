<template>

    <v-data-table
        :headers="headers"
        :items="getaddressApi"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'GetaddressApiView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            getaddressApi : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/getaddressApis'))

            temp.data._embedded.getaddressApis.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.getaddressApi = temp.data._embedded.getaddressApis;
        },
        methods: {
        }
    }
</script>

