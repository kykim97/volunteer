<template>
    <v-card outlined>
        <v-card-title>
            EditVolunteering
        </v-card-title>

        <v-card-text>
            <Number label="VolunteeringId" v-model="value.volunteeringId" :editMode="editMode"/>
            <Address offline label="Place" v-model="value.place" :editMode="editMode" @change="change"/>
            <Date label="Schedule" v-model="value.schedule" :editMode="editMode"/>
            <String label="Title" v-model="value.title" :editMode="editMode"/>
            <String label="Category" v-model="value.category" :editMode="editMode"/>
            <Number label="Personnel" v-model="value.personnel" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="editVolunteering"
            >
                EditVolunteering
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'EditVolunteeringCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.volunteeringId = 0;
            this.value.place = {};
            this.value.schedule = '2025-03-04';
            this.value.title = '';
            this.value.category = '';
            this.value.personnel = 0;
        },
        watch: {
        },
        methods: {
            editVolunteering() {
                this.$emit('editVolunteering', this.value);
            },
            close() {
                this.$emit('closeDialog');
            },
            change() {
                this.$emit('input', this.value);
            },
        }
    }
</script>

