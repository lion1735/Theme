-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: k7c203.p.ssafy.io    Database: feed
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Board`
--

DROP TABLE IF EXISTS `Board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Board` (
  `idx` int NOT NULL AUTO_INCREMENT,
  `alertCount` int NOT NULL,
  `city` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `latitude` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `longitude` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `modifyTime` datetime DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `place` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `theme_idx` int DEFAULT NULL,
  `user_idx` int DEFAULT NULL,
  PRIMARY KEY (`idx`),
  KEY `city_idx` (`city`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Board`
--

LOCK TABLES `Board` WRITE;
/*!40000 ALTER TABLE `Board` DISABLE KEYS */;
INSERT INTO `Board` VALUES (1,0,'전국','2022-11-18 04:30:56','녹차라떼가 맛있어요! 분위기 최고','35.070851159319','126.997368692613','2022-11-18 04:30:56','화순하다','전남 화순군 화순읍 유천길 48-13',1,1),(2,0,'광주','2022-11-18 04:36:04','3단계는 매워요.. 2단계 먹어,,ㅎ','35.1897727666982','126.824623032715','2022-11-18 04:36:04','애상마라탕 수완점','광주 광산구 임방울대로332번길 13',4,3),(3,0,'광주','2022-11-18 04:36:38','봄에 가면 벚꽃구경 하기 좋고\n밤에는 조명이 화려한 곳','35.2034325397424','126.872771957976','2022-11-18 04:36:38','양산호수공원','광주 북구 하서로 309',5,2),(4,0,'광주','2022-11-18 04:39:00','친절하고 맛있어요?','35.2046958168678','126.899121753412','2022-11-18 04:39:00','탕화쿵푸마라탕 일곡점','광주 북구 설죽로 506-9',4,3),(5,0,'광주','2022-11-18 04:40:49','돼지고기 뒷고기모듬 강추!!ㅎㅎ','35.1919807755355','126.811807910195','2022-11-18 04:40:49','돈구이바람났네닭이랑','광주 광산구 풍영로229번길 41',3,5),(6,0,'전국','2022-11-18 04:48:07','애월 흑돼지 맛집!','33.45929136547025','126.31134629517365','2022-11-18 04:48:07','고이정 본점','제주특별자치도 제주시 애월읍 애월로 6',9,3),(7,0,'광주','2022-11-18 04:51:05','프랭크 커피도 맛있구 크로플은 필수!!','35.1900291430687','126.829954248125','2022-11-18 04:51:05','프랭크커핀바 수완점','광주 광산구 수완로52번길 24-2',8,5),(8,0,'광주','2022-11-18 04:51:52','고기도 구워주셔서 편하게 맛있게 먹고옴 ㅎㅎ','35.1913890947792','126.830460883528','2022-11-18 04:51:52','제주올레돈','광주 광산구 수완로74번길 30-4',3,5),(9,0,'전국','2022-11-18 04:53:18','비빔국수 최고!!!!','33.251745326745','126.560751219246','2022-11-18 04:53:18','고씨네천지국수','제주특별자치도 서귀포시 중앙로79번길 4',9,3),(10,0,'광주','2022-11-18 04:56:59','오후 6시 이후엔 개가 많아요,,,\n그래도 넓고 좋아여 ㅎ','35.2093343865534','126.895127223772','2022-11-18 04:56:59','일곡제1근린공원','광주 북구 일곡로49번길 35-1',2,3),(11,0,'광주','2022-11-18 05:05:52','예향정 광주 수완점 2층 드림빌 203호 \n컴퓨터 사양 \n5800x \n3080 SUPRIM \n3600 cl14 32G 램','35.1915468786306','126.812747696498','2022-11-18 05:05:52','예향정 광주수완점','광주 광산구 장신로19번안길 19-3',10,4),(12,0,'서울','2022-11-18 05:08:19','연어 최고 ㅎ\n술이 숳술숳술술술','37.547586132522','126.922656402684','2022-11-18 05:08:19','버들골이야기 상수점','서울 마포구 독막로 84',11,3),(13,0,'서울','2022-11-18 05:09:57','매운탕 맛집 .ᐟ \n화장실은 나가서 왼쪽 건물로 가세요 ㅎ','37.5490082042647','126.915213295432','2022-11-18 05:09:57','어사출또 합정역점','서울 마포구 양화로6길 18',11,3),(14,0,'전국','2022-11-18 05:29:52','시금치버거 냠냠 또먹자 냠냠','33.548984211344525','126.65506337446807','2022-11-18 05:29:52','무거버거','제주특별자치도 제주시 조천읍 조함해안로 356',9,3),(15,0,'전국','2022-11-18 05:32:01','먹기는 귀찮지만 맛은 조아ㅏ','33.3899089881431','126.22776937829279','2022-11-18 05:32:01','피어22','제주특별자치도 제주시 한림읍 금능7길 22',9,3),(16,1,'광주','2022-11-18 05:32:13','수완지구 초돈 모르면 수완지구 사람 아님;;','35.1912340501076','126.830452421678','2022-11-18 05:32:13','초돈','광주 광산구 수완로74번길 30-6',3,5),(17,0,'광주','2022-11-18 05:43:15','친절하고 맛있어요\n고기 존맛','35.1481211304467','126.918067122282','2022-11-18 05:43:15','어나더키친 충장로점','광주 동구 금남로 242-1',13,3),(18,0,'광주','2022-11-18 05:47:16','반반 존맛 ㅎ','35.145377005112','126.92888122351','2022-11-18 05:47:16','호랑이곱창','광주 동구 필문대로287번길 15-6',13,3),(19,0,'광주','2022-11-18 05:49:23','음악소리가 커요\n마요네즈, 콘, 마늘, 쌈장에 쌈싸먹으면 최고','35.1765557997908','126.913456405721','2022-11-18 05:49:23','정통집 전남대점','광주 북구 우치로100번길 17',14,3),(20,0,'광주','2022-11-18 05:52:16','냉면이 땡길땐? 벼락','35.1776155476328','126.901342055869','2022-11-18 05:52:16','벼락','광주 북구 설죽로214번길 70-6',14,3),(21,0,'광주','2022-11-18 05:55:26','드디어 광주 라멘 맛집!!!!!!!','35.1490043472495','126.923399722209','2022-11-18 05:55:26','호시마츠라멘','광주 동구 제봉로110번길 15',13,3),(22,0,'광주','2022-11-18 07:02:12','봄에 산책하기 좋아요','35.2034325397424','126.872771957976','2022-11-18 07:02:12','양산호수공원','광주 북구 하서로 309',19,2),(23,0,'광주','2022-11-18 12:37:47','산책하기 정말 좋은 수완 호수공원\n\n밤 산책 음악분수는 필수코스 !','35.1888191406789','126.820931549133','2022-11-18 12:37:47','수완호수공원 분수','광주 광산구 장신로82번길 57',21,4),(24,0,'광주','2022-11-18 12:40:38','커피도 맛있고 디자인도 예뻤던 카페 ㅎㅎ','35.18787319647434','126.83130921327114','2022-11-18 12:40:38','어트','광주 광산구 수완로50번길 65',8,5),(25,0,'광주','2022-11-18 13:37:06','ㅎㅎ','35.1893040682788','126.892561766707','2022-11-18 13:37:06','듣는가게','광주 북구 중외길25번길 17',20,2),(26,0,'광주','2022-11-18 23:24:01','무난','35.1775724447359','126.895098870913','2022-11-18 23:24:01','로바다구주 용봉직영점','광주 북구 저불로 35',20,2),(27,0,'광주','2022-11-19 04:23:20','고실중 근처 산책하기 좋아요','35.19278356141295','126.81276462317818','2022-11-19 04:23:20','고실중학교','광주 광산구 풍영로229번길 30',21,4),(28,0,'광주','2022-11-19 04:25:23','양산동 호수공원은/는 7.6 km (11,000-걸음) 입니다.','35.2034325397424','126.872771957976','2022-11-19 04:25:23','양산호수공원','광주 북구 하서로 309',21,4),(29,0,'광주','2022-11-19 05:19:25','사양은 별로인데 음료가 맛있어요','35.1905450643093','126.815415894354','2022-11-19 05:19:25','아이리스PC Cafe 장덕점','광주 광산구 장신로50번길 4',10,4),(30,0,'광주','2022-11-19 05:20:34','자리가 구분되어있어 추천','35.1911917648989','126.813929948821','2022-11-19 05:20:34','스타덤PC 광주장덕점','광주 광산구 풍영로 219',10,4),(31,0,'광주','2022-11-19 05:21:55','무난무난 합니다','35.1918732800856','126.813989882991','2022-11-19 05:21:55','시즌아이PC방 수완점','광주 광산구 풍영로 229',10,4),(32,0,'광주','2022-11-19 05:22:55','학생들이 많아요','35.1903803668748','126.828460263969','2022-11-19 05:22:55','블랑PC방','광주 광산구 수완로 59',10,4),(33,0,'광주','2022-11-19 07:51:15','민 초 조 아','35.20561500305231','126.89888999764591','2022-11-19 07:51:15','할리스 광주일곡점','광주 북구 송해로 81',25,2),(34,0,'광주','2022-11-19 08:07:14','민초 좋아하시죠?','35.1874037166553','126.900662678719','2022-11-19 08:07:14','할리스 광주오치점','광주 북구 서하로 185',25,2),(35,0,'서울','2022-11-19 12:50:40','노랑 공룡이 반겨줍니다','37.47987085425559','126.89531616772265','2022-11-19 12:50:40','ㅋㅋ다방','서울 구로구 디지털로26길 38',25,2),(36,0,'광주','2022-11-19 12:54:08','무난','35.194736297860665','126.87107916514042','2022-11-19 12:54:08','GS25 연제힐스테이트점','광주 북구 양일1로 19-16',25,2),(37,0,'광주','2022-11-19 13:11:44','진한 초코맛 민초','35.19494396778745','126.90007812650735','2022-11-19 13:11:44','카페52 삼각점','광주 북구 설죽로 402',25,2),(38,0,'광주','2022-11-19 13:42:09','갈치액젓에 찍어먹으면 살살 녹아요','35.1765361847921','126.895446007425','2022-11-19 13:42:09','제주돈사촌','광주 북구 저불로 24',26,2),(39,0,'광주','2022-11-19 13:45:26','갈치액전 크','35.1765361847921','126.895446007425','2022-11-19 13:45:26','제주돈사촌','광주 북구 저불로 24',26,2),(40,0,'광주','2022-11-19 13:46:42','ㅅㄷㄴㅅ','35.1765361847921','126.895446007425','2022-11-19 13:46:42','제주돈사촌','광주 북구 저불로 24',26,2),(41,0,'광주','2022-11-19 13:54:29','b','35.2075569793756','126.823745769093','2022-11-19 13:54:29','빅혼','광주 광산구 임방울대로 552',26,2),(42,0,'광주','2022-11-20 01:41:43','특수부위 고기들이 참 맛있어요 !','35.1919807755355','126.811807910195','2022-11-20 01:41:43','돈구이바람났네닭이랑','광주 광산구 풍영로229번길 41',28,4),(43,0,'광주','2022-11-20 01:59:15','커피 크로플 맛집 !','35.1900291430687','126.829954248125','2022-11-20 01:59:15','프랭크커핀바 수완점','광주 광산구 수완로52번길 24-2',29,4),(44,0,'광주','2022-11-20 02:30:51','티라미수 맛있어요ㅎㅎ','35.18966470583129','126.82783482720427','2022-11-20 02:30:51','투썸플레이스 광주수완우미점','광주 광산구 수완로49번길 14',8,5),(45,0,'광주','2022-11-20 02:36:10','ㅎㅎ','35.1765361847921','126.895446007425','2022-11-20 02:36:10','제주돈사촌','광주 북구 저불로 24',30,2),(46,0,'광주','2022-11-20 02:38:05','정말 맛있는 곱창집이에요 !','35.1914231793904','126.829059772708','2022-11-20 02:38:05','돌곱1991 수완본점','광주 광산구 수완로 70',32,4),(47,0,'광주','2022-11-20 02:42:02','액젓에 찍어먹으면 살살 녹음','35.1765361847921','126.895446007425','2022-11-20 02:42:02','제주돈사촌','광주 북구 저불로 24',30,2),(48,0,'광주','2022-11-20 03:03:56','ㅎ','35.2102609287225','126.876003334792','2022-11-20 03:03:56','화덕구이집','광주 북구 양산택지로37번길 33',30,2),(49,0,'광주','2022-11-20 03:26:57','족 발','35.1893504983766','126.892066522544','2022-11-20 03:26:57','더족','광주 북구 매곡로69번길 27',30,2),(50,0,'전국','2022-11-20 03:42:28','b','35.2772945524747','127.306927023411','2022-11-20 03:42:28','라이첸','전남 곡성군 오곡면 기차마을로 237',30,2),(51,0,'광주','2022-11-20 04:08:56','','35.22431406471364','126.89424238616951','2022-11-20 04:08:56','광주패밀리랜드','광주 북구 우치로 677',19,2),(52,0,'광주','2022-11-20 04:22:11','직접 구워주시고 맛있어요 ㅎㅎ\n가기 전 예약은 필수 @@!!','35.1912340501076','126.830452421678','2022-11-20 04:22:11','초돈','광주 광산구 수완로74번길 30-6',34,5),(53,0,'광주','2022-11-20 04:23:50','ㅎ','35.2034325397424','126.872771957976','2022-11-20 04:23:50','양산호수공원','광주 북구 하서로 309',33,2),(54,0,'광주','2022-11-20 12:29:39','...','35.2013497537911','126.86877362764','2022-11-20 12:29:39','상업예술','광주 북구 양산제로 77',37,8),(55,0,'광주','2022-11-20 12:36:50','냠','35.19494396778745','126.90007812650735','2022-11-20 12:36:50','카페52 삼각점','광주 북구 설죽로 402',37,8),(56,0,'전국','2022-11-21 01:13:14','조아','33.4813314604689','126.515336952574','2022-11-21 01:13:14','할리스 제주연북로점','제주특별자치도 제주시 오남로 166',38,8);
/*!40000 ALTER TABLE `Board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-21 12:45:41
