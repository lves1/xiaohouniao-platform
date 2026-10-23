package com.xiaohouniao.config;

import com.xiaohouniao.model.dto.*;
import com.xiaohouniao.model.entity.SysUser;
import com.xiaohouniao.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final SysUserService sysUserService;
    private final ActivityService activityService;
    private final VolunteerService volunteerService;
    private final MediaService mediaService;
    private final CommunityService communityService;
    private final TopicService topicService;

    @Override
    public void run(String... args) {
        initAdmin();
        if (activityService.count() > 0) return;
        initCommunities();
        initTopics();
        initActivities();
        initVolunteers();
        initMedia();
        log.info("测试数据初始化完成");
    }

    private void initAdmin() {
        if (sysUserService.getByUsername("admin") == null) {
            SysUser admin = new SysUser();
            admin.setUsername("admin");
            admin.setPassword(new BCryptPasswordEncoder().encode("admin123"));
            admin.setNickname("超级管理员");
            admin.setRole("SUPER_ADMIN");
            admin.setStatus(1);
            sysUserService.save(admin);
            log.info("初始化超级管理员账号: admin / admin123");
        }
    }

    private void initCommunities() {
        if (communityService.count() == 0) {
            communityService.create(c("太和社区", "石排镇太和社区新时代文明实践站", 1));
            communityService.create(c("石排村", "石排镇石排村委会", 2));
            communityService.create(c("庙边王社区", "石排镇庙边王社区综合服务中心", 3));
            communityService.create(c("向西村", "石排镇向西村委会", 4));
            communityService.create(c("燕窝村", "石排镇燕窝村委会", 5));
            communityService.create(c("沙角村", "石排镇沙角村委会", 6));
            communityService.create(c("新湾社区", "虎门镇新湾社区居委会", 7));
            communityService.create(c("江边村", "企石镇江边村委会", 8));
            communityService.create(c("南面村", "谢岗镇南面村委会", 9));
            communityService.create(c("松山湖园区", "松山湖高新技术产业开发区", 10));
        }
    }

    private CommunityDTO c(String name, String desc, int sort) {
        CommunityDTO dto = new CommunityDTO();
        dto.setName(name);
        dto.setDescription(desc);
        dto.setSortOrder(sort);
        return dto;
    }

    private void initTopics() {
        topicService.create(t("暑期托管", "普惠托管与科创素质拓展", "blue", "fa-sun",
                "暑期爱心托管班、科创编程课堂，解决务工家庭后顾之忧，点亮小候鸟多彩假期", 1));
        topicService.create(t("心理健康月", "粤心安·心灵成长之旅", "pink", "fa-heart",
                "专注力训练、亲子关系建设，为小候鸟心理健康保驾护航", 2));
        topicService.create(t("非遗文化课堂", "传承非遗·美育浸润", "orange", "fa-feather",
                "龙舟文化、草花灯笼、仿绒花发簪…沉浸式体验非遗之美", 3));
        topicService.create(t("百千万·莞一夏", "科技研学·城市体验", "emerald", "fa-microscope",
                "走进科技企业、博物馆，在研学中增长见识、激发梦想", 4));
    }

    private TopicDTO t(String title, String subtitle, String color, String icon, String desc, int sort) {
        TopicDTO dto = new TopicDTO();
        dto.setTitle(title);
        dto.setSubtitle(subtitle);
        dto.setCoverColor(color);
        dto.setIcon(icon);
        dto.setDescription(desc);
        dto.setSortOrder(sort);
        dto.setIsPublished(1);
        return dto;
    }

    private void initActivities() {
        activityService.create(a("普惠托管兜底服务——「朗工童行·不负所托」爱心托管",
                "2026年暑假，大朗镇总工会联动村（社区）、辖区企业开展爱心托管公益项目，共开设10个标准化爱心托管班，累计服务超400名来莞小候鸟。",
                """
                2026年暑假，针对大朗镇外来务工人员集中、暑期儿童看护难的民生痛点，大朗镇总工会联动村（社区）、辖区企业开展「朗工童行·不负所托」爱心托管公益项目，共开设10个标准化爱心托管班，累计服务超400名来莞小候鸟，于8月下旬圆满结营。

                托管班秉持「智育+心育」双轨育人模式，开设红色宣讲、趣味文体、职场观摩等丰富课程，切实解决务工家庭后顾之忧。

                【特色课程一览】
                · 红色宣讲：讲述革命历史故事，传承红色基因
                · 趣味文体：篮球、跳绳、绘画等综合素质拓展
                · 职场观摩：走进企业生产线，了解父母工作环境
                · 安全教育：防火防溺水、交通安全知识普及""",
                "课程活动", "太和社区", "太和社区党群服务中心",
                LocalDate.of(2026, 7, 15), 400, 30));

        activityService.create(a("科创特色素质拓展——编程启蒙与AI潮玩设计",
                "大朗镇工人文化宫托管班联动东莞职业技术学院人工智能学院义教团队，开设编程启蒙、AI潮玩设计等科创特色课程。",
                """
                大朗镇工人文化宫托管班联动东莞职业技术学院人工智能学院义教团队，开设编程启蒙、AI潮玩设计等科创特色课程，引导小候鸟自主设计趣味程序、手工制作创意文创作品。

                【课程亮点】
                · Scratch编程启蒙：通过可视化编程工具，让小候鸟在拖拽积木式编程中理解逻辑思维
                · AI潮玩设计：结合AI绘画工具，引导孩子们设计属于自己的潮玩形象
                · 3D打印体验：将设计的模型通过3D打印变为实物
                · 机器人互动：与智能机器人对话、互动，感受人工智能的魅力

                在趣味科创实践中开拓视野、锻炼逻辑思维、激发创新潜能，为孩子们带来高质量、有温度的暑期托管服务。""",
                "课程活动", "太和社区", "大朗镇工人文化宫",
                LocalDate.of(2026, 7, 20), 60, 15));

        activityService.create(a("第八届「爱启一夏·莞护童行」「候鸟归家」公益夏令营",
                "2025年7月21日，第八届候鸟归家公益夏令营正式开营，开启为期十天的青少年公益研学成长之旅，招募60名全国各地小候鸟参与研学。",
                """
                2025年7月21日，第八届「爱启一夏·莞护童行」「候鸟归家」公益夏令营正式开营，开启为期十天的青少年公益研学成长之旅。活动由东莞报业传媒集团、盟大集团联合主办，联动政府部门、公益组织、爱心企业及市直机关党员志愿团队，以党建引领公益服务，汇聚多方关爱力量，招募60名全国各地「小候鸟」参与研学。

                历经八年深耕，该活动已从单一关爱行动，升级为融合「百千万·莞一夏」、莞揭共建、莞韶帮扶的立体化公益服务矩阵。

                【十天研学路线】
                · Day1-2：开营仪式+团队破冰+安全教育
                · Day3-4：走进东莞植物园、科技馆，探索自然与科技
                · Day5-6：参观虎门炮台、海战博物馆，接受爱国主义教育
                · Day7-8：非遗文化体验——龙舟、腊肠制作
                · Day9-10：结营汇演+成果展示+感恩晚会""",
                "研学活动", "太和社区", "东莞报业大厦",
                LocalDate.of(2025, 7, 21), 60, 20));

        activityService.create(a("「莞邑网事」主题宣传——虎门「护航小候鸟·让爱不留守」夏令营",
                "2025年7月13日，莞邑网事主题宣传首场活动在虎门举行，小候鸟学习非遗渔网编织技艺、参观疍家文化展示馆、接受爱国主义教育。",
                """
                2025年7月13日，「莞邑网事」主题宣传暨关心关爱暑期「小候鸟」市镇共建活动的首场活动——「护航小候鸟，让爱不留守」夏令营活动在虎门举行。

                在新湾社区居委会，小候鸟学习了非遗渔网编织技艺，观看了非遗主题影片，并走进新湾疍家文化展示馆，了解疍家文化。

                随后孩子们参观了鸦片战争博物馆，了解鸦片战争前的中西世界、两次鸦片战争的全过程以及战争给中国社会带来的影响，接受了一场生动的爱国主义教育。

                【活动流程】
                1. 非遗渔网编织：新湾老渔民手把手教授传统渔网编织技艺
                2. 疍家文化馆：了解疍家水上居民的历史与民俗
                3. 非遗主题影片展映
                4. 鸦片战争博物馆研学
                5. 爱国主义知识问答互动""",
                "研学活动", "新湾社区", "虎门镇新湾社区居委会·鸦片战争博物馆",
                LocalDate.of(2025, 7, 13), 80, 15));

        activityService.create(a("「缤纷暑假·筑梦成长」——松山湖科技研学活动",
                "40名小候鸟走进生益科技、望野博物馆、博奥木华基因科技，在科技与文化的碰撞中开拓视野。",
                """
                「缤纷暑假 筑梦成长」2024关爱留守儿童公益夏令营活动暨2024年松山湖科技研学活动举行，40名小候鸟开启本次旅程。

                【第一站：生益科技】
                中国最大覆铜板生产商——生益科技始创于1985年，是全球电子电路基材核心供应商，集研发、生产、销售、服务于一体。孩子们参观了现代化生产车间，了解一块覆铜板从原料到成品的全过程。

                【第二站：松山湖望野博物馆】
                该博物馆以古代器物为主，藏品丰富。在讲解员的引导下，孩子们对文物及其背后的历史有了初步的认识。从商周青铜器到唐宋瓷器，一件件文物诉说着中华文明的辉煌。

                【第三站：东莞博奥木华基因科技有限公司】
                作为基因检测领域的领军企业，该公司自2015年成立以来，专注于新一代高通量测序、生物信息学分析及转化医学研究应用。研究员向孩子们详细介绍了基因检测的发展历程及应用范畴，并引导他们进入实验室，激发了他们对生命科学的浓厚兴趣。""",
                "研学活动", "松山湖园区", "松山湖高新技术产业开发区",
                LocalDate.of(2024, 8, 5), 40, 10));

        activityService.create(a("白玉兰家庭服务中心——「共建家安·家圆有你」开放日活动",
                "2024年1月20日，东莞市白玉兰家庭服务中心举办开放日暨家庭品牌展示活动，100组亲子家庭参与，现场吸引上百名居民加入。",
                """
                2024年1月20日，东莞市白玉兰家庭服务中心举办「共建家安，家圆有你」市白玉兰开放日暨家庭品牌展示活动。

                本次活动旨在通过多元化的形式，提高家庭成员对心理健康的重视，增进亲子关系，促进家庭和谐，营造健康稳定的社会氛围。活动特邀100组亲子家庭参与，现场吸引上百名居民加入。

                【活动亮点】
                · 亲子沟通工作坊：专业心理咨询师带领，教授「非暴力沟通」技巧
                · 情绪管理课堂：通过沙盘游戏、绘画治疗，帮助孩子们表达内心情感
                · 家庭关系评估：专家一对一咨询，提供家庭关系改善建议
                · 暖心下午茶：亲子共同制作甜品，增进互动与情感交流""",
                "社区活动", "太和社区", "东莞市白玉兰家庭服务中心",
                LocalDate.of(2024, 1, 20), 200, 15));

        activityService.create(a("「粤心安」——「专注力探险岛」心理健康团辅活动",
                "企石镇粤心安社会心理服务站聚焦小候鸟群体心理健康需求，开展以专注力探险岛团队合作大挑战为主题的心理健康团辅活动。",
                """
                7月10日，企石镇「粤心安」社会心理服务站在企石镇「百千万工程」典型村之一——江边村暑假夏令营活动中，嵌入以「专注力探险岛团队合作大挑战」为主题的心理健康团辅活动，通过沉浸式体验提升孩子们的专注力、情绪调节能力与团队归属感。

                本次活动邀请东莞市心阳心理有限公司国家二级心理咨询师黄怡和徐诗瑶作为活动导师，全程把控团辅活动的节奏和方向。活动以「专注力高塔」搭建为主线，分四阶段融入心理健康教育目标，让30名小候鸟在动手过程中感知专注的意义、学会情绪管理。

                【四阶段团辅设计】
                1. 破冰热身：「大风吹」游戏，建立团队安全感
                2. 专注力训练：「听声辨位」、「舒尔特方格」挑战
                3. 核心环节：「专注力高塔」搭建——团队协作完成高难度积木搭建
                4. 总结分享：孩子们分享感受，导师给予正向反馈""",
                "社区活动", "江边村", "企石镇江边村夏令营活动中心",
                LocalDate.of(2025, 7, 10), 30, 5));

        activityService.create(a("谢岗镇——夏夜公益音乐会美育体验",
                "谢岗镇依托「潮流东莞·火柴盒」文化品牌，在南面村文化广场举办小候鸟专属公益音乐会，小候鸟现场互动合唱、沉浸式感受城市文艺氛围。",
                """
                8月10日晚，谢岗镇依托「潮流东莞·火柴盒」文化品牌，在南面村文化广场举办小候鸟专属公益音乐会。

                本土乐队演绎多首经典曲目：《海阔天空》《夜空中最亮的星》《童年》…小候鸟现场互动合唱，现场掌声不断。

                【音乐会节目单】
                · 开场曲：本土乐队「火柴人」演绎《追梦赤子心》
                · 互动环节：小候鸟上台合唱《小星星》
                · 经典串烧：《童年》《同桌的你》《明天会更好》
                · 才艺展示：小候鸟代表表演葫芦丝独奏
                · 压轴：全场大合唱《我和我的祖国》

                此次活动有效增强了外来务工子女的城市认同感与归属感，让孩子们在音乐中感受城市的温度与文艺魅力。""",
                "社区活动", "南面村", "谢岗镇南面村文化广场",
                LocalDate.of(2025, 8, 10), 150, 10));

        activityService.create(a("中堂镇——「国潮文化·趣味黏土」非遗公益课堂",
                "中堂镇常态化开展小候鸟专属美育系列活动，带领30余名企业小候鸟趣味学习虎头鞋、东莞龙舟、青花瓷、汉服文化等传统技艺。",
                """
                中堂镇常态化开展小候鸟专属美育系列活动。7月24日，「国潮文化 趣味黏土」八大主题公益课堂落地，涵盖虎头鞋、东莞龙舟、青花瓷、汉服文化等非遗内容，带领30余名企业小候鸟趣味学习传统技艺。

                【八大主题课程】
                1. 虎头鞋黏土：学习虎头鞋的文化寓意，用黏土制作迷你虎头鞋
                2. 东莞龙舟：了解龙舟竞渡文化，制作黏土龙舟模型
                3. 青花瓷：认识青花瓷的历史，用蓝色黏土绘制青花图案
                4. 汉服文化：学习汉服形制，用黏土制作汉服人偶
                5. 京剧脸谱：了解京剧角色，绘制特色脸谱
                6. 皮影戏：认识皮影艺术，制作简易皮影
                7. 中国结：学习传统绳结编织
                8. 剪纸艺术：体验窗花剪纸

                课程结束后举办作品展，孩子们的创意作品惊艳全场。""",
                "课程活动", "太和社区", "中堂镇新时代文明实践中心",
                LocalDate.of(2025, 7, 24), 30, 8));

        activityService.create(a("中堂镇——「寻龙探秘」龙舟非遗研学之旅",
                "组织小候鸟参观龙舟基地、体验扒龙舟、制作文创、品尝龙舟美食，深度感受本土龙舟文化底蕴。",
                """
                8月3日，中堂镇组织「寻龙探秘」龙舟非遗研学活动，通过沉浸式体验让孩子们深度感受本土龙舟文化底蕴。

                【研学流程】
                1. 龙舟文化讲座：讲解东莞龙舟的历史渊源与竞渡习俗
                2. 参观龙舟制作基地：观看龙舟工匠手工打造龙舟的全过程，了解选材、榫卯、彩绘等传统技艺
                3. 龙舟体验：在专业教练带领下，孩子们穿上救生衣，分组体验扒龙舟，感受团队协作的力量
                4. 文创制作：亲手绘制龙舟主题环保袋、制作龙舟模型
                5. 龙舟美食：品尝龙舟饭、龙舟饼等传统美食

                8月9日晚，还举办小候鸟专属火柴盒音乐会，孩子们登台展演、全员互动合唱，并收获文具暖心大礼包。""",
                "研学活动", "太和社区", "中堂镇龙舟文化基地",
                LocalDate.of(2025, 8, 3), 50, 12));

        activityService.create(a("厚街——「百千万·莞一夏」小候鸟艺术之旅非遗研学",
                "50组小候鸟亲子家庭在鑫源食品文化博物馆了解和学习非遗，包括厚街腊肠制作、DIY古风草花纸灯笼、仿绒花发簪手工体验。",
                """
                2024年8月8日，「百千万·莞一夏」小候鸟艺术之旅非遗研学活动在鑫源食品文化博物馆举行，50组小候鸟亲子家庭在欢乐中了解和学习非遗，感受传统文化的魅力。

                本次研学活动由东莞市文化馆主办，厚街镇文化服务中心、镇妇联承办，东莞市文化馆厚街分馆和企业共享文化馆协办。

                【活动内容】
                1. 厚街腊肠制作技艺：非遗传承人现场展示传统腊肠制作工艺，亲子家庭亲手体验灌肠、扎绳，了解传承百年的厚街味道
                2. DIY古风草花纸灯笼：用传统草花纸制作古风灯笼，感受传统手工艺的温暖与美好
                3. 仿绒花发簪非遗手工：学习仿绒花制作技艺，亲手制作一枚精致发簪送给妈妈
                4. 博物馆探秘：参观食品文化博物馆，了解东莞饮食文化发展史""",
                "研学活动", "太和社区", "厚街镇鑫源食品文化博物馆",
                LocalDate.of(2024, 8, 8), 100, 15));
    }

    private ActivityDTO a(String title, String summary, String content,
                          String category, String communityName, String location,
                          LocalDate date, int participants, int volunteers) {
        ActivityDTO dto = new ActivityDTO();
        dto.setTitle(title);
        dto.setSummary(summary);
        dto.setContent(content);
        dto.setCategory(category);
        dto.setCommunityName(communityName);
        dto.setLocation(location);
        dto.setActivityDate(date);
        dto.setParticipantCount(participants);
        dto.setVolunteerCount(volunteers);
        dto.setIsPublished(1);
        dto.setIsFeatured(1);
        return dto;
    }

    private void initVolunteers() {
        volunteerService.create(v("TEAM", "东莞职业技术学院AI义教团", "东莞职业技术学院",
                15, "人工智能学院优秀学生组成的义教团队，连续三年参与暑期托管志愿服务，累计服务小候鸟超500人次。",
                "科技圆梦——AI义教团的三年坚守",
                """
                从2022年起，东莞职业技术学院人工智能学院的15名大学生组成AI义教团，每年暑期走进社区托管班。

                队长陈同学说：「第一年我们教孩子们用Scratch做小游戏，有个叫小宇的孩子做出了一款简单的打地鼠游戏，他兴奋地打电话告诉在工厂加班的爸爸。那一刻我觉得，我们做的事特别有意义。」

                三年来，AI义教团累计开设编程课程120课时，辅导小候鸟300余人次。他们不仅教技术，更在孩子们心中播下了科技梦想的种子。去年，有3名曾经参加托管班的孩子在中考后选择了计算机专业。

                「科技圆梦」不是一句口号，而是每个夏天都在发生的真实故事。""",
                new BigDecimal("120.0"), "太和社区", 1));

        volunteerService.create(v("TEAM", "「火柴人」本土乐队", "东莞",
                6, "东莞本土原创乐队，热衷公益演出，多次参与小候鸟关爱活动。",
                "用音乐点亮夏夜——「火柴人」与南面村的故事",
                """
                8月10日的南面村文化广场，夜幕降临，灯光亮起，「火柴人」乐队的吉他声吸引了全村的孩子。

                主唱阿杰说：「我们唱《夜空中最亮的星》时，台下有个小姑娘跟着大声唱，唱到最后哭了。后来才知道她爸妈都在深圳打工，暑假才能来东莞和爷爷奶奶团聚。」

                乐队成立五年来，参与公益活动超过50场。他们说，音乐不只是娱乐，更是连接人与人的桥梁。""",
                new BigDecimal("50.0"), "南面村", 2));

        volunteerService.create(v("INDIVIDUAL", "黄怡", "东莞市心阳心理有限公司",
                1, "国家二级心理咨询师，专注于儿童青少年心理健康教育，累计服务时长超300小时。",
                "专注力高塔——看见每个孩子的闪光点",
                """
                在企石镇江边村的专注力团辅活动中，黄怡老师遇到了一个特别安静的女孩晓琳。搭建「专注力高塔」时，其他孩子都在争抢积木，只有晓琳安静地观察。

                黄老师没有催促，而是坐在她旁边，轻声问：「你觉得从哪里开始比较好？」

                十分钟后，晓琳搭出了全场最稳固的高塔底座。黄老师在总结时说：「专注不一定要大声喧哗，安静的观察也是一种专注。晓琳让我看到了安静的力量。」

                这堂课后，晓琳的奶奶告诉黄老师，孩子回家后第一次主动跟她聊了很久。黄怡说：「心理健康教育不是修正问题，而是看见每个孩子的闪光点。」""",
                new BigDecimal("300.0"), "江边村", 3));

        volunteerService.create(v("TEAM", "广东科技学院「科技圆梦」突击队", "广东科技学院",
                20, "对接石排镇「百千万工程」的高校突击队，负责本平台内容运营与维护。",
                "青春赋能——扎根石排的「科技圆梦」突击队",
                """
                广东科技学院「科技圆梦」突击队是共青团石排镇委员会的结对高校团队，自成立以来深度参与小候鸟关爱平台的建设与运营。

                团队20名成员分为三个小组：技术组负责平台开发维护，内容组负责活动报道与宣传，执行组深入社区开展科普课堂。

                队长表示：「我们的目标是用科技手段让每一次关爱都被看见、被记录。」团队已累计参与石排镇社区活动30余场，服务覆盖6个社区的青少年儿童。""",
                new BigDecimal("500.0"), "太和社区", 4));
    }

    private VolunteerDTO v(String type, String name, String school, int members,
                           String desc, String storyTitle, String storyContent,
                           BigDecimal hours, String community, int sort) {
        VolunteerDTO dto = new VolunteerDTO();
        dto.setType(type);
        dto.setName(name);
        dto.setSchool(school);
        dto.setMemberCount(members);
        dto.setDescription(desc);
        dto.setStoryTitle(storyTitle);
        dto.setStoryContent(storyContent);
        dto.setServiceHours(hours);
        dto.setServiceCommunity(community);
        dto.setSortOrder(sort);
        dto.setIsPublished(1);
        return dto;
    }

    private void initMedia() {
        mediaService.create(m("东莞日报：爱心托管班让小候鸟暑假有「趣」处",
                "东莞日报", "ARTICLE",
                "大朗镇开设10个标准化爱心托管班，以「智育+心育」双轨模式为来莞小候鸟提供高质量暑期服务。",
                LocalDate.of(2026, 7, 16), 1));

        mediaService.create(m("南方+：第八届「候鸟归家」夏令营温暖启航",
                "南方+", "ARTICLE",
                "60名来自全国各地的「小候鸟」齐聚东莞，开启十天公益研学之旅。",
                LocalDate.of(2025, 7, 22), 2));

        mediaService.create(m("东莞广播电视台：虎门「护航小候鸟」夏令营——非遗与爱国教育的碰撞",
                "东莞广播电视台", "ARTICLE",
                "小候鸟学习渔网编织、参观鸦片战争博物馆，在研学中接受爱国主义教育。",
                LocalDate.of(2025, 7, 14), 3));

        mediaService.create(m("羊城晚报：石排「科技圆梦」突击队——高校力量赋能基层服务",
                "羊城晚报", "ARTICLE",
                "广东科技学院20名大学生扎根石排，用科技手段助力小候鸟关爱平台建设。",
                LocalDate.of(2026, 6, 20), 4));
    }

    private MediaDTO m(String title, String source, String type, String summary, LocalDate date, int sort) {
        MediaDTO dto = new MediaDTO();
        dto.setTitle(title);
        dto.setSource(source);
        dto.setType(type);
        dto.setSummary(summary);
        dto.setPublishDate(date);
        dto.setSortOrder(sort);
        dto.setIsPublished(1);
        return dto;
    }
}
