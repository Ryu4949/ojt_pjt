import { createSlice } from "@reduxjs/toolkit";

const initialState = {
    id: "",
    name: "",
    email: "",
    department: "",
    rank: "",
    startDate: "",
    lastChangeDate: ""
}

export const userSlice = createSlice({
    name: 'user',
    initialState,
    reducers: {
        setUser: (state, action) => {
            state.id = action.payload.id;
            state.email = action.payload.email;
            state.name = action.payload.name;
            state.department = action.payload.department;
            state.rank = action.payload.rank;
            state.startDate = action.payload.startDate;
            state.lastChangeDate = action.payload.lastChangeDate;
        },
        removeUser: (state) => {
            state.id = "";
            state.email = "";
            state.name = "";
            state.department = "";
            state.rank = "";
            state.startDate = "";
            state.lastChangeDate = "";
        }
    }
})

export const { setUser, removeUser } = userSlice.actions;
export default userSlice.reducer;