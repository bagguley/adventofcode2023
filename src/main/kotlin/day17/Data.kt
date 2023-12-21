package day17

val testData = """2413432311323
3215453535623
3255245654254
3446585845452
4546657867536
1438598798454
4457876987766
3637877979653
4654967986887
4564679986453
1224686865563
2546548887735
4322674655533""".split("\n")

val data = """211332313114143133434324222211434511424134345413413656654231245423216434424452613141163242122214533442323255355354312412122214412112342123223
212132234434344413224223425412235542511125134445554136543213263136623362163641265326312152424545214412311153541215242114423212142423234121313
312213432321414114421421534422141235341514243544323331644633255352613264125144313663652436641115123244235341524131322551432111124121424141133
232222342122131443143122115235512315453225332325351441254326156322532114434164152223211446321335162131511325552313415212433132411331332122332
113212423223324413243152325443115151441344255546152124344662543645561546222266536335441232222652425143155324525433513315532224141442323423121
112334244244442112411222555352454335211645524122125562555564534262244513663352151141455236153423255541343251414453144411223323431231442341231
211212144144434341152224542414152324326641133515233625561222335224356463654426454463254664642545256214344443142131224212125554132341141144144
221341314343422251412124455131125552126553342622354121224134632245164113141552516435463143332561413133462411321144444244312433312432322243131
142134341333232124411331233515335415452163655412565353415453544154777441333277244422232446416552553421463633325552253515332214211433221134244
441214311113114212211151531552136345224151365616345531236123154523323616716752612311524421511153244142451463323413314145314213454412322143332
432444111121253325244312131241314423351553632213114622432363763664345735276532632127273535426265424656214664266654312515222453142231132431343
233112421241542144442113435346662415641434434562626377171132753213451327412273627141523635411126631356164566665525344423225512534112412144412
433432334121145441154533523616515255264644563432551332247677636754327665216315577344574721265712253554134616315314133411111422321512144113441
314114323245433431244251234543225626141325622671777141457146735424321712243644137223742153357216424625441463452536131253535353112255411133343
311442141533322215234332265154434123514225225472761542375513313731143766331115151356641465313514212331663135542126324363324544344544331213413
131243214511522132151511144563515231624125535645123671531153562272734175551673374553515771754766777222311314232454161423322251345243241443413
331123223252513355555431554234466456434442576374713435526637414333167417466143244521155327552343452577231446222362145141223434121215121424333
132312313222454122553462635415641213423343153727254734432145663763217324551522165642233533613563415561726121615246462633663454323452322424323
133322424412251244415336533551356332667554645174321174652732445524474411175331221355122161531467211366521535321254465342641421225354354534231
212232511443425212345342543342165545234715576626246314674172575674857886836524578542244661724711367116457562243532124161113221315242511553433
344231514234451222352444443552235524753634577123756144627654647232773832586435687546552415421131251323333243255146623465632361241534212214242
142222254414133416325152256524135327661173154155545677388847864642266578532566572263575461755365513265373416264535316432445325221552251115442
132523421524511133123114416651231215577376432432651585487554247274338254474464533666383648562445513461776237261133242612646141422315451555454
441123142415354333566254365632471372141131473331637876366557264368753424225828443867276435324744617336654242464274465452324433432541235354455
221521424242551314511161463112521536645311257478846428638457245555845373274225588644747458626558151412757771652321434566144554154121115421152
434452234315222616636216462331421513336424374537758472278483363246774344855425266877468546753653577716777517423764124564311443541423252352314
242511412343332661115345561772451643246425656255533536857268763866272828373525822682657735223832864553456671743171511536532311534513133431312
441545524532234144633614644336433332756447378746546256664235782424776857765742554873355455737326346726233143711453673221552616211255411224312
354242151356131155561635345473355423233215725854224633338635567782433886623446584843573752737224883345467717433551242316211126613143454241511
541123221143356154153341174555541433621765868546453876683325785775844845473468756224526833545435637677427444427572744275636614551112134541234
344311515263344524635245465645434451217456738524425828785483434653736365635687365542372444784386782574878675462274616366643366442613133352354
445421445234142442553627731742425626753827427282567427528769668745938688735345674364958783547248364565354431547576325566446223135136355421535
122312452242664256646112565112711517724722245847645637355343745976485536858889989775656372827583453642877746433122647137312623441313324445224
324334331513132244123254453315772253344836666558677257345737784563954833337973775746795594688624376786762672276535153233332255455414315333411
135542114441512656435616624445147424624547355673264898936596433385347538533769477478695957433778736527723422245371426572763635156322346453522
534243423562463252671724515737157622582528456567299883835338463363995997953643474959979833788966675254558756446442676271253236216665316423131
531423444141444263134215271424254686348556564337497938569448546433478436564859766854594873839442523222385386727127323153423423354131322325422
515332652645656425617756433311774875866268646685343493436554958553783433583833958867984673765575976728366622438434374542561423121645155154545
545543215161556142534525634241467742484583464798384678473453596746987496597648378434593876868687752826757478684444721254315774342156315535431
451544512612143256652661512344656685846282553765398535666898949378835354867349834789444775454843584484532285782344174376721546453532143515524
242156552653516547611722173154876643766723737595676975959935467365998595579995487686469674776336444988753772237565134444444561535661522315435
411245134221524116714364153382537847858833357365657888483939545668597755945846956648634564748936386447785624225477363714665425334361621555611
314334223432435165446675546343767854577859794746477547959779468685859988499846975886843338574568995549374873667234574233647355326644552625125
114513141234531655163417626487264653528586669587984585949844598786857874464868599475489458656944767648535767344685566431352657141321465653364
453364611154661776225354253876588726565654994744654473748859547797886579774644744858664598535484539639858865756883488661534623562632524152441
143253266163424146757425678826254743247938997348778836447548986659587574795588855664455458946848895838739646745273433171174237173326435561642
113225142651112261536554162778244336456976746585763697778795469644978884775885665755797495493564756338465747568523666536672141317151421524214
553431145225572232716126542322622445678588697844376678496787495964646664955989467995474669686976434936389465257586886343555513561131546126526
341642624521274673121172534774276563483969699885779496455886467468485985799699745569888854984437697734897546755543234667133325543216233531415
536141624215613232411751545442524323367367643349589674674449994867746486568556497977796476989789744744554464677233278834514735326572623155121
212651352426232653264438638266634744973735696959596759684865474598779558876989788867586498685596635458676785647853244667235472755623214413321
526662242466551127435328462588363539973397784939765966789976765457868898797775458874946789744699757536399687788263678773173145333274343121116
633343243467257163732724375324864787964953984454498445666685669955675789585777898967786875445688784649568986557857854523463346617726366351133
542652124312251655513163777233842577993936653469664665555695857556557998769598967755487779974697958697457694963773473332252672163173135632634
633134331122157164734323883758448665464395339974799445576867575799755669779657759876989554599559547495498937586763678486857716461535623451362
515452611234571533646458756625365433964555839649697648976867879789885768567658768798768745475779857656688993573535258846262554342441314364315
443621531343625514426457775688574475956777849769579766894675678586896956668699885756555579878944475653599574979664488744444556163142144243552
666355246374427573413886675672524783596546869668647658466898979865675789755975895767878754598757944933673848664752833588881636247122313116646
635322552252446173675546426374859488848859654756967466997758578779967557656957999976866887768559498487858633733762533878445363351343613512621
116645455311151516113436432535464869644747599688469698986679555965699956876677776968996955745679988996348787359758468628354312566142632536246
121123641562156174767753278484474878335939954968765687786876898565777779659675686696785669795957747964659556547965742244633152746331563554623
355644121355143544367583885222399575363465599968554865668598969957588769779595677977868695488569764557558494766874538543827175344641612464232
121546466164147161146825283632867698666999564854867996585879897799868966896869797665885575867985674855398583887644236237343746346143226215265
436614516626117247668488855535485789844537869864568767656875655596888866789868586798988755984746596474359368688647478456242414542235563641621
633634564616335723546828253633486743945789945997996857586696968699666669667796998697878895567997774785333575795833444254786322455271543633436
361331351416517162585778826487465855878374958445767585768797888987988879878799665767596898876975578886454737447354327265647325664161445541521
362414517626415637354754282382467859764655658487984785758989587688986797687666678598969885768577497544436455785994662456446672652261774552155
252225416361273633676457477649489539647889867656954575789755976996768687967998966696988686795568546865743839835945444684825432326276442313465
256454416774332513724877466836869839573955445587558778699567767976868898969988876799868888566958856595588768477878256624332315722227712266645
251431311664672646266448727783799686334367786886688977585688978666878778776897699899879569689465985696488966754437277233268437266612262226215
132551456214274276534657643478683959437594957854777956575758998869887796688868678996995766598888956499598773645786526766275312746416677343621
416315261334225464438257273888854933973989697595858958596968897696867788879877789859698786689744766458963938695336833627626422542122267456554
421345644577661173534532325586889679455376687994985975999997888699768899696976986875856555597779996958468333963747664365856233531631423451523
553363132763565264587743826248598664698986894799549967858869886999886868796869996987956685688796754756684755939648686555873874142254566436534
653524334616134442368847847588569397939797677658495777877775867679868899867666967797958877597478549848764648959793736632568711647571311522361
623616451765456225766474833754639596548767557746467875959898578798899796687996987759967858974475897566596448674388383844656211233624562155235
541421363353615321547277647723796893756779999844558987997777759766867878876988677778599885765774596768694755895735688553743567157516224224643
543116516776144736368458687483889773593994464977897665756589568888777897979786998787868595677784669858774956758433235578555264734123174464115
636541536445572254645338548743776997447888888866695676659677999586988888896989685758575595946746898975653396568565864268723732431233565661212
513222252246445175143753847837734765679344688477676698769698865679976797897897589898798698559486567658694457848455254787532753212745675331241
625136445374663123663655832755345354976634956459944485788979878957788897877985879859768775884699677489767333846983422382666647421352226425225
324443225174677461748683365672347478738555788774844897999798869576887687986978789886666578476648657444585493879576577478474134611721734355163
424314254211444744532768584466499489649935678588669579659987866969875557798699976968777786888957459787865346389828272827668522435735372264463
265125521227517713633838388828644363898737796686877789589855788695588958689657665876966777855975549975634333844338837247526355562544551233222
525336633272215466423626368846466456464787455579666747779566785755555969757788597968655666856794648685567879553367274863385533273645155515446
243311312465162534151636583364739696567398469878599466485665898655758785785687565866687788958985474969433866453677655856831354347443762145131
264443244614476736234852323645273556749677447846557799448968886878656677859599889759594785494888946787986655644875754742255465153417125235324
662164354524445157747425657647689346866394695788688888885797999776859985577958969868876947787449589543464567396733553353521634753225622665254
514425236451223756735764726344352896573675835799645465748759767985855966587885768758799649579985847766868449368873684325821363423347125523531
624454214667235623342258323445784877367564656585857778949688688569889577596876876574958468546474464458477796632224766646426562366616222415521
251123656312532521715722736583532466476666474584464687598845898866579975955569965664879774646598483795585484646845622587652525117627162132333
163154153244326523535174467822736788387965448734965694994489944798588556785595685675488848888899749863469698684588575773173761233622613525333
151331512646714153226228566325542338478578764536574949498689674685599985685794874588989884548984585998857839424246746683274524445665446564241
522125436653516611267735652575462746493657677565758588979487954444677467985944759669487585597983397398648644355678344837257177434554366456214
425156155136745622777632255745828643699849839675874455756949656956754955659575659887798969587549347857474687556443424785335416411662456222412
456112456662645651321367533625343887465933988375989859769944944885846958468976468558974779483979539968978826652443873732254557744743321421511
252543516516116471113422584687254755473679944983455574459989899499996746675975464655485684783535448659593568228464743613721311276625563522566
126441624643131422661477674383358855857653655754785449744795986875774569474886594786685558473734658369644484838832457356267122113643266642214
515612113264144171331622232265463255585988984757677793854649994965967566864844579895576797898777565376797833738632784756735365277152445331424
254225242565334134137745631683742274237453876668369633846477956845454594864486897574944735957999686663758553243756377567262664371336341355164
443411616466643174343244136362258366276233735799868977765644765785754648465689786978677878383449888387455852572642846211361423556144134456424
214461256112666374743527244124355566666443443834965658546456494847697654995699975467758679638894695967587655888755321115373467561335215443141
424166241432664123466515253266378746622565593939778835444683896337955666789459748395338595759636337566735372672548113661661252645642325365355
234143514562565144143635177173337876725533767733546393395474635873545758393445694696747735466548857368587374546253275236111252612254135134453
342315422564522166632274173515358224583585568786877394844445594466474353789785739593459945448487933638277644247425745441363252456555462243323
421145213536544343211461477334364327357333467783393654367676489599468948585553334349889834579685453723225344262851633511155612262236664163254
445453246121426262366374476466363784853622663745986555363375659999385769766996839463888346333656424354248668485121245352157725216266426643345
511314136536341441524364755652766785686853462326369674894967485785554446748998683569557747596762788764824584731445143123765264113565454514125
421113241123431631646623316311257443262665643835654679697933858673843737847787484394934457457665273585225753714614116416737612443624432444333
432322514152551326562161445126524175683478454227745436644649489573773743595577756765933646436267337573352476227253336437412656541355342341145
441331424431232262132224244632546611683245632564372256654473488446395647686784448697358543247236357742487764261517365722346651214311532522132
454323422326524542343366473376237356378846232442565827878298334893977847667584457584786472363548623324444377756116351145412236216232122411331
535215433315131612541256367421446743238337552467336755247464343979447677656596456572556345446354445746385342135143523413631352115315324432221
153234343224152425256146575563345432752576735432852856237657275824647958995768547643522738458554435226756267241475212322433255433356144445312
142512142152165155341634256732265747443115824683874824485832375475336557554528486856733323433668826733265236415314736655234616224663352422234
431345144124253623644632464342575566322774845876477683223254765547225556783234827547723757348745587746315327637752722124355255513621522234212
142344553222466231151411663436714616176454748664263422463633276288362757658622826622387252226577236617254721126472711252665451513225111342452
251525235241235162344614426124333552474561565723586768453536525783664575573648223363338684376443457225337627351667163226643532513443323144212
442544325435321313613523424455655114131153475765573448734727534658425364264358763662577468435726252773375671675727312661631164442135132534253
224511553345154644342524521234722554172247326113476284458754687532483454757255572458274674332772433317745677122164112354141423165134231332152
442313111215315161343636334441112263531144232647723558583558466853464823776643255438358655763336453357232121754665553425125561145555141414523
233445234212244211116323116362314324673537777714561211136488384484342736664582545482355831474314167541164723656113262563221116541314442245344
431245343331514534521134111345252327442542313271611473766274782225377322743852383337515263452644643447341652742256451551254461212311443113332
444431354311552442442461661111651156711762233333166445564415545476888434638882738647577113426745163414273235134211613435462132525553152112114
232434535113145531525364251645553226433236344747772174463644621645726521743717274321153726241545645264217156136522255646222124432225121443333
342423245553252444241151231665432544541733727534426443374676265537114134236717523372166344421232622362311123133411161244615151354453141513324
123112342234321355254345451454115322255473315614354221314116145231536731626175136534353326234744437162562652155213234226625555425441444223132
312321124555122312314431646262226125513615675446326612521412324666545247254731652233651237166243211234412122164362462223133133223131441233434
413132133241542542131351136235662524441121266445577537232444372642311712423624235533163575446452133436343551256554361525224315334332451231144
122232442221532514523535221334233614322532142156616214173612731334644454373741431663367772627765255141563453536662152411234525353311542221114
122432134121552221111312325313143263326162133264773327217254215712252275124276172111156356311411425225133364411331611125145212313232142322234
134142343234154243425124151162254416531362235516161637411151131345343521271246734363174665714634132413442235225564432414355512513432234141311
423244241241224144313115541343631412413312666216611512362352654734126155457267512773726455431313245221663633663241233323143215415443121323342
224132224333121321212341341311463524164225531331531152444645216524113215162716255662233356115316615662524565313642255454413214542334134112114
411124314243132345222223143422522315526243251366223624261435664413571136641472554343354325566114156153421332312221145211533315411344411321144
244412441113233453342124311143132532543513253512611344325543442551242156465142136643124332641365146163135121425241121424224522121343121442313
134421231232142243552433355231532332435243511655462223433565552442446513242622325323252412455343613452651163234441445531525322442222114444131
322421221111414411413542543412445332436314312152256436111351351112443643145563414563561153341314355656424124413535534155142334324222222344431
212113322331443213434455432121143512121332123655111235243261361364332132153242614136115431456622664336232455232522435352424311133422412332311
332312332222443434241132515152122341335533226461126526512545145464625526451521662623433245422136461122541141154353214153521223312144341333322
323133213424312311241324224511441433415211233531156215452452353635353165434233223513541552216241435245242413453131315554233444141232133243323""".split("\n")