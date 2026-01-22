import React, { useState } from 'react';
import axios from 'axios';
const SurveyForm = () => {
    const [formData, setFormData] = useState({
        monthlyMileage: '',
        electricityBill: '',
        dietType: 'Non-Vegetarian' 
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

const handleSubmit = async (e) => {
    e.preventDefault();
    const token = localStorage.getItem('token');

    try {
        const response = await axios.post("http://localhost:8080/api/survey/survey", formData, {
            headers: {
                'Authorization': `Bearer ${token}` // If you are using JWT security
            }
        });
        alert("Survey submitted successfully!");
        console.log(response.data);
    } catch (error) {
        console.error("There was an error saving the survey!", error);
        alert("Failed to submit survey.");
    }
};

    return (
        <div style={{ padding: '20px' }}>
            <h2>Carbon Footprint Survey</h2>
            <form onSubmit={
                handleSubmit
                }>
                <div>
                    <label>Monthly Mileage (km):</label><br/>
                    <input 
                        type="number" name="monthly_mileage" 
                        value={
                            formData.monthly_mileage
                        } onChange={handleChange} required 
                    />
                </div><br/>

                <div>
                    <label>Monthly Electricity Bill:</label><br/>
                    <input 
                        type="number" name="electricityBill" 
                        value={
                            formData.electricityBill
                        } onChange={handleChange} required 
                    />
                </div><br/>

                <div>
                    <label>Diet Type:</label><br/>
                    <select name="dietType" value={formData.dietType} onChange={handleChange}>
                        <option value="Vegetarian">Vegetarian</option>
                        <option value="Non-Vegetarian">Non-Vegetarian</option>
                        <option value="Vegan">Vegan</option>
                    </select>
                </div><br/>

                <button type="submit">Complete Local Step</button>
            </form>
        </div>
    );
};

export default SurveyForm;