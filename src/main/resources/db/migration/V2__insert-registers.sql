-- Inserts for `profile` table
INSERT INTO `foroalura`.`profile` (`name`) VALUES ('Java Student');
INSERT INTO `foroalura`.`profile` (`name`) VALUES ('Java Instructor');
INSERT INTO `foroalura`.`profile` (`name`) VALUES ('Java Consultant');
INSERT INTO `foroalura`.`profile` (`name`) VALUES ('Java Architect');
INSERT INTO `foroalura`.`profile` (`name`) VALUES ('Java Analyst');

-- Inserts for `user` table
INSERT INTO `foroalura`.`user` (`name`, `username`, `password`, `profile_id`) VALUES ('Sarah Adams', 'sarahadams', 'java456', 1);
INSERT INTO `foroalura`.`user` (`name`, `username`, `password`, `profile_id`) VALUES ('Daniel Brown', 'dbrown', 'javaDev456', 2);
INSERT INTO `foroalura`.`user` (`name`, `username`, `password`, `profile_id`) VALUES ('Lily Clark', 'lilyc', 'codingJava', 3);
INSERT INTO `foroalura`.`user` (`name`, `username`, `password`, `profile_id`) VALUES ('William Lee', 'williaml', 'javaMaster', 4);
INSERT INTO `foroalura`.`user` (`name`, `username`, `password`, `profile_id`) VALUES ('Sophie Turner', 'sturner', 'javaWizard', 5);
INSERT INTO `foroalura`.`user` (`name`, `username`, `password`, `profile_id`) VALUES ('Ethan White', 'ethanw', 'java456', 1);
INSERT INTO `foroalura`.`user` (`name`, `username`, `password`, `profile_id`) VALUES ('Isabella Young', 'izzy', 'javaJava', 2);
INSERT INTO `foroalura`.`user` (`name`, `username`, `password`, `profile_id`) VALUES ('Ryan King', 'ryanking', '123java', 3);
INSERT INTO `foroalura`.`user` (`name`, `username`, `password`, `profile_id`) VALUES ('Grace Rodriguez', 'grace.r', 'secureJava123', 4);
INSERT INTO `foroalura`.`user` (`name`, `username`, `password`, `profile_id`) VALUES ('David Garcia', 'david.g', 'javaPass456', 5);
INSERT INTO `foroalura`.`user` (`name`, `username`, `password`, `profile_id`) VALUES ('Oliver Martinez', 'oliver.m', 'javaRules456', 1);
INSERT INTO `foroalura`.`user` (`name`, `username`, `password`, `profile_id`) VALUES ('Mia Hernandez', 'mia.h', 'javaExpert123', 2);
INSERT INTO `foroalura`.`user` (`name`, `username`, `password`, `profile_id`) VALUES ('Nathan Walker', 'nwalker', 'javaLover', 3);
INSERT INTO `foroalura`.`user` (`name`, `username`, `password`, `profile_id`) VALUES ('Ava Lewis', 'ava.l', 'codingJava456', 4);
INSERT INTO `foroalura`.`user` (`name`, `username`, `password`, `profile_id`) VALUES ('Alexander Wright', 'awright', 'java123', 5);

-- Inserts for `course` table
INSERT INTO `foroalura`.`course` (`name`, `category`) VALUES ('Java Programming Basics', 'Programming');
INSERT INTO `foroalura`.`course` (`name`, `category`) VALUES ('Advanced Java Programming', 'Programming');
INSERT INTO `foroalura`.`course` (`name`, `category`) VALUES ('Java Web Development', 'Web Development');
INSERT INTO `foroalura`.`course` (`name`, `category`) VALUES ('Android App Development', 'Mobile Development');
INSERT INTO `foroalura`.`course` (`name`, `category`) VALUES ('Spring Framework Essentials', 'Web Development');
INSERT INTO `foroalura`.`course` (`name`, `category`) VALUES ('Java Enterprise Edition', 'Web Development');
INSERT INTO `foroalura`.`course` (`name`, `category`) VALUES ('Java Data Structures', 'Programming');
INSERT INTO `foroalura`.`course` (`name`, `category`) VALUES ('Java GUI Applications', 'Programming');
INSERT INTO `foroalura`.`course` (`name`, `category`) VALUES ('Java Network Programming', 'Networking');
INSERT INTO `foroalura`.`course` (`name`, `category`) VALUES ('Java Microservices', 'Microservices');

-- Inserts for `topic` table
INSERT INTO `foroalura`.`topic` (`title`, `message`, `creation_date`, `status`, `user_id`, `course_id`) VALUES ('Java Lambda Expressions', 'Exploring the power of lambda expressions in Java', NOW(), 1, 1, 1);
INSERT INTO `foroalura`.`topic` (`title`, `message`, `creation_date`, `status`, `user_id`, `course_id`) VALUES ('JavaFX Basics', 'Introduction to JavaFX for building desktop applications', NOW(), 1, 2, 1);
INSERT INTO `foroalura`.`topic` (`title`, `message`, `creation_date`, `status`, `user_id`, `course_id`) VALUES ('Servlets and JSP', 'Understanding Servlets and JavaServer Pages for web development', NOW(), 1, 3, 3);
INSERT INTO `foroalura`.`topic` (`title`, `message`, `creation_date`, `status`, `user_id`, `course_id`) VALUES ('Microservices Architecture', 'Designing scalable microservices architecture using Java', NOW(), 1, 4, 10);
INSERT INTO `foroalura`.`topic` (`title`, `message`, `creation_date`, `status`, `user_id`, `course_id`) VALUES ('Spring Security Configuration', 'Securing Spring applications with Spring Security', NOW(), 1, 5, 5);
INSERT INTO `foroalura`.`topic` (`title`, `message`, `creation_date`, `status`, `user_id`, `course_id`) VALUES ('Java Data Structures Overview', 'Introduction to data structures like lists, queues, and trees in Java', NOW(), 1, 6, 7);
INSERT INTO `foroalura`.`topic` (`title`, `message`, `creation_date`, `status`, `user_id`, `course_id`) VALUES ('Java GUI Design Patterns', 'Exploring common design patterns for building Java GUI applications', NOW(), 1, 7, 8);
INSERT INTO `foroalura`.`topic` (`title`, `message`, `creation_date`, `status`, `user_id`, `course_id`) VALUES ('Java Networking Basics', 'Fundamentals of networking programming in Java', NOW(), 1, 8, 9);
INSERT INTO `foroalura`.`topic` (`title`, `message`, `creation_date`, `status`, `user_id`, `course_id`) VALUES ('Spring Boot Microservices', 'Developing microservices with Spring Boot for Java', NOW(), 1, 9, 10);
INSERT INTO `foroalura`.`topic` (`title`, `message`, `creation_date`, `status`, `user_id`, `course_id`) VALUES ('Java Concurrency', 'Understanding concurrency concepts and programming in Java', NOW(), 1, 10, 1);

-- Inserts for `response` table
INSERT INTO `foroalura`.`response` (`message`, `creation_date`, `solution`, `topic_id`, `user_id`) VALUES ('Lambda expressions can simplify code by providing concise syntax', NOW(), 'Use lambda expressions for functional programming paradigms', 1, 2);
INSERT INTO `foroalura`.`response` (`message`, `creation_date`, `solution`, `topic_id`, `user_id`) VALUES ('JavaFX provides rich UI components for building modern applications', NOW(), 'Explore Scene Builder for visually designing JavaFX UIs', 2, 3);
INSERT INTO `foroalura`.`response` (`message`, `creation_date`, `solution`, `topic_id`, `user_id`) VALUES ('Servlets handle HTTP requests and generate responses dynamically', NOW(), 'Combine Servlets with JSP for dynamic web content generation', 3, 4);
INSERT INTO `foroalura`.`response` (`message`, `creation_date`, `solution`, `topic_id`, `user_id`) VALUES ('Microservices promote modularity and scalability in modern applications', NOW(), 'Use technologies like Spring Boot for easy microservice development', 4, 5);
INSERT INTO `foroalura`.`response` (`message`, `creation_date`, `solution`, `topic_id`, `user_id`) VALUES ('Spring Security offers authentication and authorization features for Spring applications', NOW(), 'Configure security rules using Spring Security configuration classes', 5, 1);
INSERT INTO `foroalura`.`response` (`message`, `creation_date`, `solution`, `topic_id`, `user_id`) VALUES ('Data structures like ArrayList and LinkedList are commonly used in Java', NOW(), 'Choose the appropriate data structure based on performance requirements', 6, 2);
INSERT INTO `foroalura`.`response` (`message`, `creation_date`, `solution`, `topic_id`, `user_id`) VALUES ('Design patterns like MVC and Observer are commonly used in Java GUI development', NOW(), 'Apply design patterns to ensure scalable and maintainable GUI applications', 7, 3);
INSERT INTO `foroalura`.`response` (`message`, `creation_date`, `solution`, `topic_id`, `user_id`) VALUES ('Java provides libraries like Socket and URLConnection for network programming', NOW(), 'Handle network communication effectively using Java networking libraries', 8, 4);
INSERT INTO `foroalura`.`response` (`message`, `creation_date`, `solution`, `topic_id`, `user_id`) VALUES ('Spring Boot simplifies microservices development with auto-configuration and embedded servers', NOW(), 'Use Spring Boot starters to quickly set up microservices projects', 9, 5);
INSERT INTO `foroalura`.`response` (`message`, `creation_date`, `solution`, `topic_id`, `user_id`) VALUES ('Concurrency in Java can be achieved using threads or higher-level abstractions like Executors', NOW(), 'Be cautious of thread safety issues and use synchronization where necessary', 10, 1);
