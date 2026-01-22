import axios from 'axios';

const API_URL = "http://localhost:8080/api/goals";

export const fetchAvailableGoals = () => axios.get(API_URL);
export const acceptGoal = (userId, goalId) => 
    axios.post(`${API_URL}/assign?userId=${userId}&goalId=${goalId}`);