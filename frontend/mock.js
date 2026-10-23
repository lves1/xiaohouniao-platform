// 小候鸟关爱平台 - Mock API 数据
// 无需后端即可预览前端页面
window.MOCK_API = true;

const __MOCK = {
    'auth.login': { code: 200, msg: 'success', data: { token: 'mock-jwt-token-2026' } },

    'public.activity.list': {
        code: 200, data: {
            total: 11, size: 10,
            records: [
                { id:1, title:'普惠托管兜底服务——「朗工童行·不负所托」爱心托管',
                  summary:'2026年暑假，大朗镇总工会联动村（社区）、辖区企业开展爱心托管公益项目，共开设10个标准化爱心托管班，累计服务超400名来莞小候鸟。',
                  content:'2026年暑假，针对大朗镇外来务工人员集中、暑期儿童看护难的民生痛点，大朗镇总工会联动村（社区）、辖区企业开展「朗工童行·不负所托」爱心托管公益项目，共开设10个标准化爱心托管班，累计服务超400名来莞小候鸟，于8月下旬圆满结营。\n\n托管班秉持「智育+心育」双轨育人模式，开设红色宣讲、趣味文体、职场观摩等丰富课程，切实解决务工家庭后顾之忧。\n\n【特色课程一览】\n· 红色宣讲：讲述革命历史故事，传承红色基因\n· 趣味文体：篮球、跳绳、绘画等综合素质拓展\n· 职场观摩：走进企业生产线，了解父母工作环境\n· 安全教育：防火防溺水、交通安全知识普及',
                  coverUrl:'', category:'课程活动', communityName:'太和社区', location:'太和社区党群服务中心',
                  activityDate:'2026-07-15', participantCount:400, volunteerCount:30, viewCount:128, isPublished:1, createTime:'2026-07-15' },
                { id:2, title:'科创特色素质拓展——编程启蒙与AI潮玩设计',
                  summary:'大朗镇工人文化宫托管班联动东莞职业技术学院人工智能学院义教团队，开设编程启蒙、AI潮玩设计等科创特色课程。',
                  content:'大朗镇工人文化宫托管班联动东莞职业技术学院人工智能学院义教团队，开设编程启蒙、AI潮玩设计等科创特色课程，引导小候鸟自主设计趣味程序、手工制作创意文创作品。\n\n【课程亮点】\n· Scratch编程启蒙：通过可视化编程工具，让小候鸟在拖拽积木式编程中理解逻辑思维\n· AI潮玩设计：结合AI绘画工具，引导孩子们设计属于自己的潮玩形象\n· 3D打印体验：将设计的模型通过3D打印变为实物\n· 机器人互动：与智能机器人对话、互动，感受人工智能的魅力\n\n在趣味科创实践中开拓视野、锻炼逻辑思维、激发创新潜能，为孩子们带来高质量、有温度的暑期托管服务。',
                  coverUrl:'', category:'课程活动', communityName:'太和社区', location:'大朗镇工人文化宫',
                  activityDate:'2026-07-20', participantCount:60, volunteerCount:15, viewCount:86, isPublished:1, createTime:'2026-07-20' },
                { id:3, title:'第八届「爱启一夏·莞护童行」「候鸟归家」公益夏令营',
                  summary:'2025年7月21日，第八届候鸟归家公益夏令营正式开营，开启为期十天的青少年公益研学成长之旅，招募60名全国各地小候鸟参与研学。',
                  content:'2025年7月21日，第八届「爱启一夏·莞护童行」「候鸟归家」公益夏令营正式开营，开启为期十天的青少年公益研学成长之旅。活动由东莞报业传媒集团、盟大集团联合主办，联动政府部门、公益组织、爱心企业及市直机关党员志愿团队，以党建引领公益服务，汇聚多方关爱力量，招募60名全国各地「小候鸟」参与研学。\n\n历经八年深耕，该活动已从单一关爱行动，升级为融合「百千万·莞一夏」、莞揭共建、莞韶帮扶的立体化公益服务矩阵。\n\n【十天研学路线】\n· Day1-2：开营仪式+团队破冰+安全教育\n· Day3-4：走进东莞植物园、科技馆，探索自然与科技\n· Day5-6：参观虎门炮台、海战博物馆，接受爱国主义教育\n· Day7-8：非遗文化体验——龙舟、腊肠制作\n· Day9-10：结营汇演+成果展示+感恩晚会',
                  coverUrl:'', category:'研学活动', communityName:'太和社区', location:'东莞报业大厦',
                  activityDate:'2025-07-21', participantCount:60, volunteerCount:20, viewCount:210, isPublished:1, createTime:'2025-07-21' },
                { id:4, title:'「莞邑网事」主题宣传——虎门夏令营',
                  summary:'2025年7月13日，莞邑网事主题宣传首场活动在虎门举行，小候鸟学习非遗渔网编织技艺、参观疍家文化展示馆、接受爱国主义教育。',
                  content:'2025年7月13日，「莞邑网事」主题宣传暨关心关爱暑期「小候鸟」市镇共建活动的首场活动——「护航小候鸟，让爱不留守」夏令营活动在虎门举行。\n\n在新湾社区居委会，小候鸟学习了非遗渔网编织技艺，观看了非遗主题影片，并走进新湾疍家文化展示馆，了解疍家文化。随后孩子们参观了鸦片战争博物馆，接受了一场生动的爱国主义教育。\n\n【活动流程】\n1. 非遗渔网编织：新湾老渔民手把手教授传统渔网编织技艺\n2. 疍家文化馆：了解疍家水上居民的历史与民俗\n3. 非遗主题影片展映\n4. 鸦片战争博物馆研学\n5. 爱国主义知识问答互动',
                  coverUrl:'', category:'研学活动', communityName:'新湾社区', location:'虎门镇新湾社区居委会·鸦片战争博物馆',
                  activityDate:'2025-07-13', participantCount:80, volunteerCount:15, viewCount:165, isPublished:1, createTime:'2025-07-13' },
                { id:5, title:'「缤纷暑假·筑梦成长」——松山湖科技研学活动',
                  summary:'40名小候鸟走进生益科技、望野博物馆、博奥木华基因科技，在科技与文化的碰撞中开拓视野。',
                  content:'「缤纷暑假 筑梦成长」2024关爱留守儿童公益夏令营活动暨2024年松山湖科技研学活动举行，40名小候鸟开启本次旅程。\n\n【第一站：生益科技】\n中国最大覆铜板生产商——生益科技始创于1985年，是全球电子电路基材核心供应商。孩子们参观了现代化生产车间，了解一块覆铜板从原料到成品的全过程。\n\n【第二站：松山湖望野博物馆】\n该博物馆以古代器物为主，藏品丰富。在讲解员的引导下，孩子们对文物及其背后的历史有了初步的认识。\n\n【第三站：东莞博奥木华基因科技有限公司】\n作为基因检测领域的领军企业，研究员向孩子们详细介绍了基因检测的发展历程及应用范畴，并引导他们进入实验室，激发了他们对生命科学的浓厚兴趣。',
                  coverUrl:'', category:'研学活动', communityName:'松山湖园区', location:'松山湖高新技术产业开发区',
                  activityDate:'2024-08-05', participantCount:40, volunteerCount:10, viewCount:93, isPublished:1, createTime:'2024-08-05' },
                { id:6, title:'白玉兰家庭服务中心——「共建家安·家圆有你」开放日活动',
                  summary:'2024年1月20日，东莞市白玉兰家庭服务中心举办开放日暨家庭品牌展示活动，100组亲子家庭参与。',
                  content:'2024年1月20日，东莞市白玉兰家庭服务中心举办「共建家安，家圆有你」市白玉兰开放日暨家庭品牌展示活动。\n\n【活动亮点】\n· 亲子沟通工作坊：专业心理咨询师带领，教授「非暴力沟通」技巧\n· 情绪管理课堂：通过沙盘游戏、绘画治疗，帮助孩子们表达内心情感\n· 家庭关系评估：专家一对一咨询，提供家庭关系改善建议\n· 暖心下午茶：亲子共同制作甜品，增进互动与情感交流',
                  coverUrl:'', category:'社区活动', communityName:'太和社区', location:'东莞市白玉兰家庭服务中心',
                  activityDate:'2024-01-20', participantCount:200, volunteerCount:15, viewCount:78, isPublished:1, createTime:'2024-01-20' },
                { id:7, title:'「粤心安」——「专注力探险岛」心理健康团辅活动',
                  summary:'企石镇粤心安社会心理服务站聚焦小候鸟群体心理健康需求，开展专注力团辅活动。',
                  content:'7月10日，企石镇「粤心安」社会心理服务站在江边村暑假夏令营活动中，嵌入以「专注力探险岛团队合作大挑战」为主题的心理健康团辅活动，通过沉浸式体验提升孩子们的专注力、情绪调节能力与团队归属感。\n\n【四阶段团辅设计】\n1. 破冰热身：「大风吹」游戏，建立团队安全感\n2. 专注力训练：「听声辨位」、「舒尔特方格」挑战\n3. 核心环节：「专注力高塔」搭建——团队协作完成高难度积木搭建\n4. 总结分享：孩子们分享感受，导师给予正向反馈',
                  coverUrl:'', category:'社区活动', communityName:'江边村', location:'企石镇江边村夏令营活动中心',
                  activityDate:'2025-07-10', participantCount:30, volunteerCount:5, viewCount:56, isPublished:1, createTime:'2025-07-10' },
                { id:8, title:'谢岗镇——夏夜公益音乐会美育体验',
                  summary:'谢岗镇在南面村文化广场举办小候鸟专属公益音乐会，小候鸟现场互动合唱、沉浸式感受城市文艺氛围。',
                  content:'8月10日晚，谢岗镇依托「潮流东莞·火柴盒」文化品牌，在南面村文化广场举办小候鸟专属公益音乐会。\n\n【音乐会节目单】\n· 开场曲：本土乐队「火柴人」演绎《追梦赤子心》\n· 互动环节：小候鸟上台合唱《小星星》\n· 经典串烧：《童年》《同桌的你》《明天会更好》\n· 才艺展示：小候鸟代表表演葫芦丝独奏\n· 压轴：全场大合唱《我和我的祖国》',
                  coverUrl:'', category:'社区活动', communityName:'南面村', location:'谢岗镇南面村文化广场',
                  activityDate:'2025-08-10', participantCount:150, volunteerCount:10, viewCount:112, isPublished:1, createTime:'2025-08-10' },
                { id:9, title:'中堂镇——「国潮文化·趣味黏土」非遗公益课堂',
                  summary:'中堂镇常态化开展小候鸟专属美育系列活动，带领30余名企业小候鸟趣味学习传统技艺。',
                  content:'中堂镇常态化开展小候鸟专属美育系列活动。7月24日，「国潮文化 趣味黏土」八大主题公益课堂落地，涵盖虎头鞋、东莞龙舟、青花瓷、汉服文化等非遗内容。\n\n【八大主题课程】\n1. 虎头鞋黏土：学习虎头鞋的文化寓意，用黏土制作迷你虎头鞋\n2. 东莞龙舟：了解龙舟竞渡文化，制作黏土龙舟模型\n3. 青花瓷：认识青花瓷的历史，用蓝色黏土绘制青花图案\n4. 汉服文化：学习汉服形制，用黏土制作汉服人偶\n5. 京剧脸谱：了解京剧角色，绘制特色脸谱\n6. 皮影戏：认识皮影艺术，制作简易皮影\n7. 中国结：学习传统绳结编织\n8. 剪纸艺术：体验窗花剪纸',
                  coverUrl:'', category:'课程活动', communityName:'太和社区', location:'中堂镇新时代文明实践中心',
                  activityDate:'2025-07-24', participantCount:30, volunteerCount:8, viewCount:89, isPublished:1, createTime:'2025-07-24' },
                { id:10, title:'中堂镇——「寻龙探秘」龙舟非遗研学之旅',
                  summary:'组织小候鸟参观龙舟基地、体验扒龙舟、制作文创、品尝龙舟美食，深度感受本土龙舟文化底蕴。',
                  content:'8月3日，中堂镇组织「寻龙探秘」龙舟非遗研学活动。\n\n【研学流程】\n1. 龙舟文化讲座：讲解东莞龙舟的历史渊源与竞渡习俗\n2. 参观龙舟制作基地：观看龙舟工匠手工打造龙舟的全过程\n3. 龙舟体验：在专业教练带领下，孩子们穿上救生衣，分组体验扒龙舟\n4. 文创制作：亲手绘制龙舟主题环保袋、制作龙舟模型\n5. 龙舟美食：品尝龙舟饭、龙舟饼等传统美食',
                  coverUrl:'', category:'研学活动', communityName:'太和社区', location:'中堂镇龙舟文化基地',
                  activityDate:'2025-08-03', participantCount:50, volunteerCount:12, viewCount:145, isPublished:1, createTime:'2025-08-03' },
                { id:11, title:'厚街——「百千万·莞一夏」小候鸟艺术之旅非遗研学',
                  summary:'50组小候鸟亲子家庭在鑫源食品文化博物馆了解和学习非遗，包括厚街腊肠制作、DIY古风草花纸灯笼、仿绒花发簪手工体验。',
                  content:'2024年8月8日，「百千万·莞一夏」小候鸟艺术之旅非遗研学活动在鑫源食品文化博物馆举行，50组小候鸟亲子家庭在欢乐中了解和学习非遗。\n\n【活动内容】\n1. 厚街腊肠制作技艺：非遗传承人现场展示传统腊肠制作工艺\n2. DIY古风草花纸灯笼：用传统草花纸制作古风灯笼\n3. 仿绒花发簪非遗手工：学习仿绒花制作技艺\n4. 博物馆探秘：参观食品文化博物馆',
                  coverUrl:'', category:'研学活动', communityName:'太和社区', location:'厚街镇鑫源食品文化博物馆',
                  activityDate:'2024-08-08', participantCount:100, volunteerCount:15, viewCount:67, isPublished:1, createTime:'2024-08-08' }
            ]
        }
    },

    'public.activity.statistics': {
        code: 200, data: { totalActivities: 11, totalParticipants: 1190, totalVolunteers: 135 }
    },

    'public.volunteer.list': {
        code: 200, data: {
            total: 4, size: 20,
            records: [
                { id:1, type:'TEAM', name:'东莞职业技术学院AI义教团', school:'东莞职业技术学院', memberCount:15,
                  description:'人工智能学院优秀学生组成的义教团队，连续三年参与暑期托管志愿服务，累计服务小候鸟超500人次。',
                  storyTitle:'科技圆梦——AI义教团的三年坚守',
                  storyContent:'从2022年起，东莞职业技术学院人工智能学院的15名大学生组成AI义教团，每年暑期走进社区托管班。\n\n队长陈同学说：「第一年我们教孩子们用Scratch做小游戏，有个叫小宇的孩子做出了一款简单的打地鼠游戏，他兴奋地打电话告诉在工厂加班的爸爸。那一刻我觉得，我们做的事特别有意义。」\n\n三年来，AI义教团累计开设编程课程120课时，辅导小候鸟300余人次。他们不仅教技术，更在孩子们心中播下了科技梦想的种子。去年，有3名曾经参加托管班的孩子在中考后选择了计算机专业。\n\n「科技圆梦」不是一句口号，而是每个夏天都在发生的真实故事。',
                  coverUrl:'', serviceHours:120, serviceCommunity:'太和社区', sortOrder:1, isPublished:1, createTime:'2025-07-01' },
                { id:2, type:'TEAM', name:'「火柴人」本土乐队', school:'东莞', memberCount:6,
                  description:'东莞本土原创乐队，热衷公益演出，多次参与小候鸟关爱活动。',
                  storyTitle:'用音乐点亮夏夜——「火柴人」与南面村的故事',
                  storyContent:'8月10日的南面村文化广场，夜幕降临，灯光亮起，「火柴人」乐队的吉他声吸引了全村的孩子。\n\n主唱阿杰说：「我们唱《夜空中最亮的星》时，台下有个小姑娘跟着大声唱，唱到最后哭了。后来才知道她爸妈都在深圳打工，暑假才能来东莞和爷爷奶奶团聚。」\n\n乐队成立五年来，参与公益活动超过50场。他们说，音乐不只是娱乐，更是连接人与人的桥梁。',
                  coverUrl:'', serviceHours:50, serviceCommunity:'南面村', sortOrder:2, isPublished:1, createTime:'2025-07-01' },
                { id:3, type:'INDIVIDUAL', name:'黄怡', school:'东莞市心阳心理有限公司', memberCount:1,
                  description:'国家二级心理咨询师，专注于儿童青少年心理健康教育，累计服务时长超300小时。',
                  storyTitle:'专注力高塔——看见每个孩子的闪光点',
                  storyContent:'在企石镇江边村的专注力团辅活动中，黄怡老师遇到了一个特别安静的女孩晓琳。搭建「专注力高塔」时，其他孩子都在争抢积木，只有晓琳安静地观察。\n\n黄老师没有催促，而是坐在她旁边，轻声问：「你觉得从哪里开始比较好？」\n\n十分钟后，晓琳搭出了全场最稳固的高塔底座。黄老师在总结时说：「专注不一定要大声喧哗，安静的观察也是一种专注。晓琳让我看到了安静的力量。」\n\n这堂课后，晓琳的奶奶告诉黄老师，孩子回家后第一次主动跟她聊了很久。黄怡说：「心理健康教育不是修正问题，而是看见每个孩子的闪光点。」',
                  coverUrl:'', serviceHours:300, serviceCommunity:'江边村', sortOrder:3, isPublished:1, createTime:'2025-07-01' },
                { id:4, type:'TEAM', name:'广东科技学院「科技圆梦」突击队', school:'广东科技学院', memberCount:20,
                  description:'对接石排镇「百千万工程」的高校突击队，负责本平台内容运营与维护。',
                  storyTitle:'青春赋能——扎根石排的「科技圆梦」突击队',
                  storyContent:'广东科技学院「科技圆梦」突击队是共青团石排镇委员会的结对高校团队，自成立以来深度参与小候鸟关爱平台的建设与运营。\n\n团队20名成员分为三个小组：技术组负责平台开发维护，内容组负责活动报道与宣传，执行组深入社区开展科普课堂。\n\n队长表示：「我们的目标是用科技手段让每一次关爱都被看见、被记录。」团队已累计参与石排镇社区活动30余场，服务覆盖6个社区的青少年儿童。',
                  coverUrl:'', serviceHours:500, serviceCommunity:'太和社区', sortOrder:4, isPublished:1, createTime:'2025-07-01' }
            ]
        }
    },

    'public.community': {
        code: 200, data: [
            { id:1, name:'太和社区', description:'石排镇太和社区新时代文明实践站' },
            { id:2, name:'石排村', description:'石排镇石排村委会' },
            { id:3, name:'庙边王社区', description:'石排镇庙边王社区综合服务中心' },
            { id:4, name:'向西村', description:'石排镇向西村委会' },
            { id:5, name:'燕窝村', description:'石排镇燕窝村委会' },
            { id:6, name:'沙角村', description:'石排镇沙角村委会' },
            { id:7, name:'新湾社区', description:'虎门镇新湾社区居委会' },
            { id:8, name:'江边村', description:'企石镇江边村委会' },
            { id:9, name:'南面村', description:'谢岗镇南面村委会' },
            { id:10, name:'松山湖园区', description:'松山湖高新技术产业开发区' }
        ]
    },

    'public.topic': {
        code: 200, data: [
            { id:1, title:'暑期托管', subtitle:'普惠托管与科创素质拓展', coverColor:'blue', icon:'fa-sun',
              description:'暑期爱心托管班、科创编程课堂，解决务工家庭后顾之忧，点亮小候鸟多彩假期', sortOrder:1, isPublished:1 },
            { id:2, title:'心理健康月', subtitle:'粤心安·心灵成长之旅', coverColor:'pink', icon:'fa-heart',
              description:'专注力训练、亲子关系建设，为小候鸟心理健康保驾护航', sortOrder:2, isPublished:1 },
            { id:3, title:'非遗文化课堂', subtitle:'传承非遗·美育浸润', coverColor:'orange', icon:'fa-feather',
              description:'龙舟文化、草花灯笼、仿绒花发簪…沉浸式体验非遗之美', sortOrder:3, isPublished:1 },
            { id:4, title:'百千万·莞一夏', subtitle:'科技研学·城市体验', coverColor:'emerald', icon:'fa-microscope',
              description:'走进科技企业、博物馆，在研学中增长见识、激发梦想', sortOrder:4, isPublished:1 }
        ]
    },

    'admin.media.list': {
        code: 200, data: {
            total: 4, size: 20,
            records: [
                { id:1, type:'ARTICLE', title:'东莞日报：爱心托管班让小候鸟暑假有「趣」处', source:'东莞日报',
                  summary:'大朗镇开设10个标准化爱心托管班，以「智育+心育」双轨模式为来莞小候鸟提供高质量暑期服务。',
                  publishDate:'2026-07-16', sortOrder:1, isPublished:1, createTime:'2026-07-16' },
                { id:2, type:'ARTICLE', title:'南方+：第八届「候鸟归家」夏令营温暖启航', source:'南方+',
                  summary:'60名来自全国各地的「小候鸟」齐聚东莞，开启十天公益研学之旅。',
                  publishDate:'2025-07-22', sortOrder:2, isPublished:1, createTime:'2025-07-22' },
                { id:3, type:'ARTICLE', title:'东莞广播电视台：虎门「护航小候鸟」夏令营——非遗与爱国教育的碰撞', source:'东莞广播电视台',
                  summary:'小候鸟学习渔网编织、参观鸦片战争博物馆，在研学中接受爱国主义教育。',
                  publishDate:'2025-07-14', sortOrder:3, isPublished:1, createTime:'2025-07-14' },
                { id:4, type:'ARTICLE', title:'羊城晚报：石排「科技圆梦」突击队——高校力量赋能基层服务', source:'羊城晚报',
                  summary:'广东科技学院20名大学生扎根石排，用科技手段助力小候鸟关爱平台建设。',
                  publishDate:'2026-06-20', sortOrder:4, isPublished:1, createTime:'2026-06-20' }
            ]
        }
    },

    _singleActivity(id) {
        const all = this['public.activity.list'].data.records;
        const a = all.find(r => r.id == id);
        return { code: 200, data: a ? { ...a } : null };
    },
    _singleVolunteer(id) {
        const all = this['public.volunteer.list'].data.records;
        const v = all.find(r => r.id == id);
        return { code: 200, data: v ? { ...v } : null };
    }
};

(function() {
    const origFetch = window.fetch;
    window.fetch = function(url, opts) {
        if (window.MOCK_API) {
            let result = null;
            const u = typeof url === 'string' ? url : url.url || '';

            if (u.includes('/api/public/activity/statistics')) result = __MOCK['public.activity.statistics'];
            else if (u.includes('/api/public/activity') && u.split('/').length > 5) {
                const id = u.split('/').pop().split('?')[0];
                result = __MOCK._singleActivity(id);
            }
            else if (u.includes('/api/public/activity')) result = __MOCK['public.activity.list'];
            else if (u.includes('/api/public/volunteer') && u.split('/').length > 5) {
                const id = u.split('/').pop().split('?')[0];
                result = __MOCK._singleVolunteer(id);
            }
            else if (u.includes('/api/public/volunteer')) result = __MOCK['public.volunteer.list'];
            else if (u.includes('/api/public/community')) result = __MOCK['public.community'];
            else if (u.includes('/api/public/topic')) result = __MOCK['public.topic'];
            else if (u.includes('/api/admin/media')) result = __MOCK['admin.media.list'];
            else if (u.includes('/api/admin/auth/login')) result = __MOCK['auth.login'];
            else if (u.includes('/api/admin/activity') || u.includes('/api/admin/volunteer')) {
                result = { code: 200, data: { total: 0, size: 20, records: [] } };
            }

            if (result) {
                return Promise.resolve(new Response(JSON.stringify(result), {
                    status: 200, headers: { 'Content-Type': 'application/json' }
                }));
            }
        }
        return origFetch.call(window, url, opts);
    };
})();
