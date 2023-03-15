-- user_acc
INSERT INTO user_acc ("first_name", is_admin, is_contributor, "last_name", "password") VALUES ('Woodrow',false,false,'Farnham','1234' ); -- 1

-- address
INSERT INTO address ("address_line1","address_line2","address_line3","city","country","postal_code") VALUES ('The Jolly Roger','Cabin 3B','Deep Down','Atlantis','Oceania','666');--1

-- goal
INSERT INTO goal (acheived, "end_date") VALUES (false,'2023-03-28');

-- program

INSERT INTO program ("name","category") VALUES ('Beginner work capacity','Calisthenics');
INSERT INTO program ("name","category") VALUES ('Beginner fundamental strength','Weightlifting');


-- profile
INSERT INTO profile (user_id,address_id,goal_id,program_id,weight, height, disability, "medical_condition") VALUES (1,1,1,1,75,175,true,'wooden leg, one eye'); -- 1


-- Excercies
INSERT INTO exercise ("name", "description","target_muscle_group", "image_url", "video_url") VALUES('Push-up', 'Lie prone with forefeet on floor and hands slightly wider than shoulder width. Raise body up off floor by extending arms with body straight.', 'Pectoralis Major, Sternal', 'URL','URL');
INSERT INTO exercise ("name", "description","target_muscle_group", "image_url", "video_url") VALUES('Sit-up', 'Hook feet under foot brace or secure low overhang. Lie supine on floor or bench with hips bent. Place hands behind neck or on side of neck. Raise torso from bench by bending waist and hips. Return until back of shoulders contact incline board. Repeat.', 'Rectus Abdominis', 'URL','URL');
INSERT INTO exercise ("name", "description","target_muscle_group", "image_url", "video_url") VALUES('Pistol-Squat', 'Stand with arms extended out in front. Balance on one leg with opposite leg extended forward off of ground. Squat down as far as possible while keeping leg elevated off of floor. Keep back as straight as possible and supporting knee pointed same direction as foot supporting. Raise body back up to original position until knee and hip of supporting leg is straight. Repeat and continue with opposite leg.', 'Gluteus Maximus', 'URL','URL');
INSERT INTO exercise ("name", "description","target_muscle_group", "image_url", "video_url") VALUES('Pull-up', 'Step up and grasp bar with overhand wide grip.Pull body up until chin is above bar. Lower body until arms and shoulders are fully extended. Repeat.', 'Latissimus Dorsi', 'URL','URL');


-- set
INSERT INTO set_count ( exercise_id, exercise_repetitions) VALUES (1,8);--1
INSERT INTO set_count ( exercise_id, exercise_repetitions) VALUES (2,8);--2
INSERT INTO set_count ( exercise_id, exercise_repetitions) VALUES (3,8);--3
INSERT INTO set_count ( exercise_id, exercise_repetitions) VALUES (4,15);--4
INSERT INTO set_count ( exercise_id, exercise_repetitions) VALUES (1,15);--5
INSERT INTO set_count ( exercise_id, exercise_repetitions) VALUES (2,15);--6

-- workout
INSERT INTO workout ("name", "type", complete ) VALUES ('General Warm-up', 'low resistance', true);
INSERT INTO workout ("name", "type", complete ) VALUES ('Day 1 arms', 'high resistance', false);
INSERT INTO workout ("name", "type", complete ) VALUES ('Day 3', 'high repetition', false);

-- workout_set
INSERT INTO workout_setcount (workout_id,setcount_id) VALUES (1,1);
INSERT INTO workout_setcount (workout_id,setcount_id) VALUES (1,2);
INSERT INTO workout_setcount (workout_id,setcount_id) VALUES (1,3);
INSERT INTO workout_setcount (workout_id,setcount_id) VALUES (3,4);
INSERT INTO workout_setcount (workout_id,setcount_id) VALUES (3,5);
INSERT INTO workout_setcount (workout_id,setcount_id) VALUES (3,6);


