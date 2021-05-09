drop table if exists likes;
drop table if exists comments;
drop table if exists articles;
drop table if exists users;

create table if not exists users (
  id int not null auto_increment,
  fname varchar(64) not null,
  lname varchar(64) not null,
  gender char(1),
  check (gender RLIKE '[mMfF]'),
  primary key (id)
);

create table if not exists articles (
  id int not null auto_increment,
  title text not null,
  content text not null,
  author_id int not null,
  primary key (id),
  foreign key (author_id) references users(id)
);

CREATE TABLE if not exists comments
(
    id        INT PRIMARY KEY AUTO_INCREMENT,
    content   TEXT      NOT NULL,
    time      TIMESTAMP NOT NULL,
    user_id      INT       NOT NULL,
    article_id   INT,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (article_id) REFERENCES articles (id) ON DELETE CASCADE
);

create table if not exists likes (
  article_id int not null,
  user_id int not null,
  primary key (article_id, user_id),
  foreign key (article_id) references articles(id),
  foreign key (user_id) references users(id)
);





insert into users (fname, lname, gender) values
  ('Homer', 'Simpson', 'M'),
  ('Marge', 'Simpson', 'F'),
  ('Bart', 'Simpson', 'M'),
  ('Lisa', 'Simpson', 'F'),
  ('Maggie', 'Simpson', 'F'),
  ('Peter', 'Griffin', 'M'),
  ('Louis', 'Griffin', 'F'),
  ('Chris', 'Griffin', 'M'),
  ('Meg', 'Griffin', 'F'),
  ('Stewie', 'Griffin', 'M'),
  ('Brian', 'Griffin', 'M'),
  ('Stan', 'Smith', 'M'),
  ('Francine', 'Smith', 'F'),
  ('Hayley', 'Smith', 'F'),
  ('Steve', 'Smith', 'M'),
  ('Rusty', 'Venture', 'M'),
  ('Hank', 'Venture', 'M'),
  ('Dean', 'Venture', 'M');

insert into articles (title, content, author_id) values
  ('Witty Whale', 'Nam ipsum metus, semper ac nisi id, faucibus varius mauris. Nunc tempus lacus id magna dignissim volutpat. Donec laoreet ornare nisi. Duis imperdiet, nisi a maximus rutrum, tortor erat porta nunc, a lobortis odio ligula id lorem. Curabitur id justo nibh. Curabitur mauris est, volutpat eu aliquet in, finibus non dolor. Duis ornare arcu vel rutrum maximus. Duis blandit tellus eu nulla mattis vestibulum. Quisque scelerisque mattis justo vitae consequat. Maecenas dictum, elit sed interdum eleifend, eros enim vehicula justo, vitae gravida mi elit non odio.', 12),
  ('Hilarious Hyenas', 'Praesent pulvinar iaculis massa, id iaculis nibh condimentum ac. Proin vestibulum luctus justo eu fermentum. Sed lectus neque, blandit sed laoreet vel, bibendum sit amet lorem. Nullam malesuada nulla ac odio tempus, id vulputate nisi porta. Aliquam erat volutpat. Fusce venenatis, purus rhoncus scelerisque varius, dui eros tincidunt massa, scelerisque porta diam sapien id nunc. Donec blandit urna justo, at elementum turpis tempor non. Ut ante elit, ultrices ac neque nec, lobortis dapibus risus. Proin ac diam consequat, iaculis ante a, malesuada nisi. Praesent condimentum efficitur neque sed tempus.', 8),
  ('Bilious Badger', 'Nam vitae pretium dui. Suspendisse tellus sem, molestie non tellus id, tincidunt scelerisque risus. Nam malesuada magna nunc, nec volutpat lectus sollicitudin vel. Pellentesque sit amet lorem nec nibh convallis finibus in a tellus. Donec in congue nibh, ac venenatis est. Nulla tempor ligula a metus tincidunt tempus. Nullam suscipit porta congue. Nullam ipsum nibh, convallis eu tempus vel, rutrum at lacus.', 8),
  ('Enormous Elephant', 'Aliquam varius eros eget consectetur aliquam. Nullam eget mollis dolor. Aenean et aliquam elit. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aliquam venenatis viverra justo. Phasellus ut ligula id turpis varius euismod at nec tortor. Curabitur sodales eros in orci aliquam cursus nec sit amet nisi. Maecenas mollis porta elit id dictum. Donec ornare sem odio. Pellentesque et condimentum velit.', 9),
  ('Cold Cow', 'Phasellus sodales neque vel blandit efficitur. Phasellus suscipit tortor sit amet tincidunt egestas. Praesent turpis felis, imperdiet vel dui in, egestas fermentum risus. Mauris sed lectus placerat, porttitor est a, venenatis risus. Nulla at augue vitae libero gravida fermentum condimentum ac augue. Maecenas at elit at ipsum rhoncus euismod quis ac ligula. Etiam non malesuada dolor. Aenean iaculis tincidunt nibh a pharetra. In consectetur nisl sit amet neque feugiat rutrum. Fusce placerat blandit nisl non dictum. Phasellus in tincidunt nisl, sed varius libero. Sed semper, ligula sed vulputate sagittis, purus quam hendrerit dui, vel pharetra tortor sem eget libero.', 1),
  ('Energetic Eel', 'Suspendisse lectus augue, mollis in euismod ac, pretium in risus. Suspendisse cursus risus ac diam rutrum, mollis pellentesque magna posuere. Donec tempor fermentum dapibus. Integer at efficitur dui, eget blandit metus. Aenean fringilla, lectus et pulvinar aliquam, mauris elit fermentum risus, dignissim suscipit ante turpis et metus. Curabitur feugiat dui lacus, quis efficitur magna hendrerit sed. Aliquam erat volutpat. Cras eu aliquet dolor. Donec sit amet finibus arcu, non finibus elit. Ut fringilla sagittis sem.', 3),
  ('Jumping Jellyfish', 'Nunc quis dapibus dui. Aliquam eget ultricies orci. Ut ultrices venenatis mollis. Fusce id vestibulum purus. Aliquam iaculis, enim non suscipit commodo, lorem justo efficitur urna, nec ultricies quam massa gravida ex. Aliquam varius faucibus tellus non faucibus. Donec commodo venenatis odio, sit amet mollis dui rutrum vitae. Sed vel dictum elit, ut vehicula urna. Mauris congue, enim non rutrum accumsan, orci orci ultrices lectus, non consequat diam massa sed nibh. Nulla facilisi. Curabitur congue mollis imperdiet. Donec tempor faucibus porttitor.', 2),
  ('Interesting Impala', 'Donec et nisi id neque sollicitudin porta. Sed euismod ligula id tristique malesuada. Mauris blandit mi et turpis commodo aliquet a a erat. Fusce semper, turpis vitae imperdiet aliquam, odio odio tincidunt urna, et scelerisque leo leo sit amet est. Donec quis ullamcorper est. Aenean eu dolor ac felis blandit ullamcorper eget at mauris. Fusce commodo iaculis sodales.', 6),
  ('Gargantuan Goose', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. In sollicitudin elit dignissim, efficitur augue at, interdum lacus. Nulla facilisi. Vivamus vitae justo augue. Phasellus bibendum maximus mollis. Vestibulum arcu turpis, feugiat non efficitur sed, venenatis quis elit. Nam elementum est at ipsum faucibus placerat. Suspendisse vitae arcu laoreet, mollis orci nec, vehicula sapien.', 7),
  ('Angry Alpacas', 'Integer malesuada nisl nec metus porta, quis cursus nulla aliquam. Maecenas gravida massa pharetra sem feugiat ultricies. Vivamus tellus mauris, auctor id erat eu, efficitur ultrices quam. Maecenas facilisis mauris dui, at gravida nulla posuere a. Vestibulum in finibus felis, ac tincidunt lacus. Phasellus facilisis tincidunt ex, vitae fermentum tellus feugiat id. Mauris mauris urna, consequat quis ligula non, consectetur molestie augue. Nulla imperdiet pretium nunc vel placerat. Curabitur a accumsan sapien. Nam non aliquet metus, quis suscipit tortor. Pellentesque eget elit at ligula vulputate mollis. Integer hendrerit, risus in bibendum accumsan, ante erat porttitor leo, quis volutpat velit eros ac arcu. Ut venenatis congue tincidunt. Mauris et tincidunt quam.', 11),
  ('Furious Foxes', 'Nam eu dolor sed nibh egestas semper sed id est. Vivamus a mollis elit. Nullam volutpat elit vitae magna tincidunt, quis venenatis tellus lobortis. Proin tincidunt accumsan dignissim. Praesent ac libero at elit auctor tempus. Maecenas aliquam lacus eu neque bibendum, sed semper nisi posuere. Nullam et ullamcorper justo, eu sodales quam. Maecenas sit amet massa id mauris fermentum pulvinar. Pellentesque posuere ipsum eget odio accumsan, mattis lobortis nisi scelerisque. Nam in fringilla purus. Nullam pellentesque urna eu urna interdum molestie. Nunc aliquam, lorem eget condimentum porttitor, diam ex mattis ligula, rhoncus ultrices mi mauris id quam. Ut gravida dignissim gravida. Integer ac velit eros. Sed a sodales neque. Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 17),
  ('Silly Sheep', 'Vivamus neque leo, egestas nec nisi et, dictum aliquet diam. Mauris luctus, ipsum quis iaculis aliquam, tellus nibh eleifend tellus, sit amet blandit massa tortor eu lectus. Maecenas elementum efficitur mauris, nec euismod leo mollis id. Nulla iaculis vestibulum augue. Aliquam sed luctus ex, et ultricies ex. Aenean semper, dolor sed eleifend pellentesque, dolor nisl consectetur velit, ut congue orci erat ut nunc. Sed euismod nisl nisl, iaculis tempus diam volutpat et. Morbi porta imperdiet neque.', 14),
  ('Laughing Lemur', 'Etiam congue ornare nibh, in mattis lorem. Suspendisse euismod pharetra purus, vel feugiat tortor interdum nec. Curabitur fermentum molestie leo, nec lacinia ex cursus sed. Aenean id efficitur tortor, egestas tristique tellus. Ut pretium sollicitudin lorem ac dictum. Praesent scelerisque, ex ac luctus faucibus, magna risus sagittis ipsum, vitae interdum justo eros quis ligula. Nulla aliquam dui ac lectus scelerisque, in lobortis libero interdum. Nunc orci nulla, sodales sit amet tincidunt eu, euismod a diam. Nam tristique sem dolor, ac venenatis diam egestas id. Quisque est nibh, convallis ut finibus sit amet, varius sit amet quam. Sed vulputate pulvinar laoreet. Nulla non tempor purus, nec gravida orci. Nam consequat diam a tristique dapibus. Etiam sodales sit amet magna nec eleifend.', 14),
  ('Orange Ocelot', 'Praesent vel mollis lacus. Donec justo ligula, tincidunt ac purus nec, varius scelerisque enim. Praesent nec dignissim ipsum. Curabitur ultrices ipsum non enim auctor, eu cursus risus bibendum. In varius mattis ipsum, nec consectetur ante consectetur nec. Fusce tincidunt tellus nunc, vel mattis orci bibendum eu. Morbi porttitor risus at diam viverra, in rutrum lacus interdum.', 13),
  ('Magnificent Magpie', 'Vestibulum luctus dolor nec orci vestibulum, eget rutrum neque ullamcorper. Etiam congue ante nec sapien egestas porttitor. Nullam libero arcu, pellentesque quis iaculis in, accumsan at justo. Aenean blandit euismod augue, ut egestas lacus gravida ut. Mauris ipsum urna, hendrerit laoreet lacinia ut, pharetra et libero. Curabitur eget tincidunt quam. Praesent accumsan ornare tellus, eu sollicitudin massa posuere ut. Suspendisse ac libero eget quam eleifend porttitor sit amet sit amet nisl. Curabitur ac risus in nisi mattis varius ac at purus. Cras pharetra leo ut ligula efficitur mattis. Ut imperdiet lacinia laoreet.', 18);

insert into comments (content,time, user_id, article_id) values
    ('comment1', '2017-10-03 21:22:23', 1, 1),
    ('comment2','2017-10-02 21:22:23',1, 1),
    ('comment3','2017-10-01 21:22:23',1, 1),
    ('comment4','2017-10-04 21:22:23',1, 1),
    ('comment5','2017-10-05 21:22:23',1, 1),
    ('comment6','2017-10-06 21:22:23',1, 1),
    ('comment7','2017-10-07 21:22:23',1, 1),
    ('comment8','2017-10-08 21:22:23',1, 1),
    ('comment9','2017-10-09 21:22:23',1, 1),
    ('comment10','2017-10-10 21:22:23',1, 1),
    ('comment11','2017-10-11 21:22:23',1, 1),
    ('comment12','2017-10-12 21:22:23',1, 2),
    ('comment13','2017-10-13 21:22:23',1, 3),
    ('comment14','2017-10-14 21:22:23',2, 3),
    ('comment15','2017-10-15 21:22:23',3, 3),
    ('comment16','2017-10-16 21:22:23',4, 3),
    ('comment17','2017-10-17 21:22:23',5, 3),
    ('comment18','2017-10-18 21:22:23',6, 3),
    ('comment19','2017-10-19 21:22:23',7, 4),
    ('comment20','2017-10-20 21:22:23',8, 4),
    ('comment21','2017-10-21 21:22:23',9, 4),
    ('comment22','2017-10-22 21:22:23',10, 4),
    ('comment23','2017-10-23 21:22:23',11, 4);






insert into likes (article_id, user_id) values
  (1, 17),
  (2, 17),
  (3, 17),
  (4, 17),
  (5, 17),
  (6, 17),
  (7, 17),
  (8, 17),
  (9, 17),
  (10, 17),
  (11, 17),
  (12, 17),
  (13, 17),
  (14, 17),
  (15, 17),
  (1, 18),
  (2, 18),
  (3, 18),
  (4, 18),
  (5, 18),
  (6, 18),
  (7, 18),
  (8, 18),
  (9, 18),
  (10, 18),
  (11, 18),
  (12, 18),
  (13, 18),
  (14, 18),
  (15, 18),
  (1, 2),
  (2, 15),
  (2, 10),
  (3, 5),
  (3, 10),
  (3, 1),
  (3, 13),
  (3, 14),
  (3, 15),
  (3, 3),
  (3, 4),
  (3, 7),
  (4, 1),
  (4, 11),
  (4, 12),
  (4, 13),
  (4, 3),
  (4, 4),
  (5, 11),
  (5, 15),
  (5, 2),
  (5, 7),
  (6, 14),
  (6, 15),
  (6, 2),
  (6, 4),
  (6, 6),
  (6, 8),
  (7, 1),
  (7, 10),
  (7, 12),
  (7, 16),
  (7, 2),
  (7, 3),
  (7, 4),
  (7, 5),
  (7, 6),
  (7, 7),
  (8, 1),
  (8, 10),
  (8, 11),
  (8, 14),
  (8, 2),
  (8, 3),
  (8, 4),
  (8, 5),
  (8, 7),
  (8, 8),
  (9, 1),
  (9, 12),
  (9, 15),
  (9, 3),
  (9, 4),
  (9, 7),
  (9, 8),
  (9, 9),
  (10, 11),
  (10, 14),
  (10, 15),
  (10, 16),
  (10, 4),
  (10, 5),
  (10, 6),
  (10, 9),
  (11, 10),
  (11, 12),
  (11, 13),
  (11, 15),
  (11, 3),
  (11, 4),
  (11, 7),
  (11, 8),
  (11, 9),
  (12, 1),
  (12, 10),
  (12, 13),
  (12, 2),
  (12, 3),
  (12, 5),
  (13, 1),
  (13, 10),
  (13, 11),
  (13, 12),
  (13, 15),
  (13, 3),
  (13, 5),
  (13, 7),
  (13, 9),
  (14, 1),
  (14, 11),
  (14, 15),
  (14, 2),
  (14, 5),
  (14, 7),
  (15, 1),
  (15, 12),
  (15, 14),
  (15, 15),
  (15, 3),
  (15, 4),
  (15, 7),
  (15, 2);
