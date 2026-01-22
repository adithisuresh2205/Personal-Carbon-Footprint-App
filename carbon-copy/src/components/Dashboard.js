import React from 'react';
import SurveyForm from './SurveyForm';

const Dashboard = () => {
    return (
        <div style={{ padding: '20px' }}>
            <h1>User Dashboard</h1>
            <div style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '8px' }}>
                <h3>Welcome!</h3>
                <p>Your Carbon Footprint Summary will appear here.</p>
                <button onClick={() => { localStorage.removeItem('token'); window.location.href='/'; }}>Logout</button>
            </div>
            <SurveyForm />
        </div>
    );
};

export default Dashboard;