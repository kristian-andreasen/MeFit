-- Insert a user profile
INSERT INTO profile(id, email, role, first_name, last_name, age, weight, height)
VALUES ('1', 'john@example.com', 'user', 'John', 'Doe', 30, 80.5, 180.0);

-- Insert two fitness programs
INSERT INTO program (name, author, description, imageURL) VALUES('Beginner work capacity','Arnold Schwarzenegger', 'https://i.insider.com/62de9331bd18c30019d1a729?width=1000&format=jpeg&auto=webp', 'This is a description.');
INSERT INTO program (name, author, description, imageURL) VALUES ('Beginner fundamental strength','The Rock', 'https://www.muscleandfitness.com/wp-content/uploads/2019/02/ronnie-coleman-squat-barbell-1109.jpg?quality=86&strip=all', 'this is a description');

-- Insert three workouts
INSERT INTO workout (name) VALUES ('General Warm-up');
INSERT INTO workout (name) VALUES ('Day 1 arms');
INSERT INTO workout (name) VALUES ('Day 3');

-- Insert four exercises
INSERT INTO exercise (name, description, repetitions, sets) VALUES('Push-up', 'description', 1, 10);
INSERT INTO exercise (name, description, repetitions, sets) VALUES('Sit-up', 'description', 1, 10);
INSERT INTO exercise (name, description, repetitions, sets) VALUES('Pistol-Squat', 'description', 20, 20);
INSERT INTO exercise (name, description, repetitions, sets) VALUES('Pull-up', 'description', 1, 10);

-- Insert two goals, one associated with program 1
INSERT INTO goal(name, achieved, start_date, end_date, user_id, profile_id, program_id) VALUES('Get stronger', false, '2022-01-01', '2022-03-31', 1, 1, 1);

-- Associate the workouts with the goals
INSERT INTO goal_workout(goal_id, workout_id) VALUES(1, 1);

-- Associate the exercises with the workouts
INSERT INTO workout_exercise(workout_id, exercise_id) VALUES(1, 1);

