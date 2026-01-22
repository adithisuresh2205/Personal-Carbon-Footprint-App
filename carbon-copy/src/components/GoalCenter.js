import React, { useState, useEffect } from 'react';
import { fetchAvailableGoals, acceptGoal } from '../services/GoalService';

const GoalCenter = ({ userId }) => {
    const [goals, setGoals] = useState([]);

    useEffect(() => {
        fetchAvailableGoals().then(res => setGoals(res.data));
    }, []);

    const handleAccept = (goalId) => {
        acceptGoal(userId, goalId).then(() => alert("Goal Started!"));
    };

    return (
        <div className="goal-container">
            <h2>Eco-Challenges</h2>
            <div className="goal-grid">
                {goals.map(g => (
                    <div key={g.id} className="goal-card">
                        <h3>{g.title}</h3>
                        <p>{g.description}</p>
                        <button onClick={() => handleAccept(g.id)}>Accept</button>
                    </div>
                ))}
            </div>
        </div>
    );
};

export default GoalCenter;