// Simplified GoalCard logic
const GoalCard = ({ goal, onAccept }) => (
  <div className="border p-4 rounded-lg shadow-sm">
    <h3 className="font-bold">{goal.title}</h3>
    <p className="text-sm text-gray-600">{goal.description}</p>
    <button 
      onClick={() => onAccept(goal.id)}
      className="mt-2 bg-green-500 text-white px-4 py-2 rounded"
    >
      Accept Challenge
    </button>
  </div>
);