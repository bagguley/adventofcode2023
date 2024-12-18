package day25

val testData = """jqt: rhn xhk nvd
rsh: frs pzl lsr
xhk: hfx
cmg: qnr nvd lhk bvb
rhn: xhk bvb hfx
bvb: xhk hfx
pzl: lsr hfx nvd
qnr: nvd
ntq: jqt hfx bvb xhk
nvd: lhk
lsr: lhk
rzs: qnr cmg lsr rsh
frs: qnr lhk lsr""".split("\n")

val data = """mxr: qgn jjg gdm
lmm: hdm zng smb
kzf: dqp xcr xhz gbb cql
zzn: szc htq bkp rxh
qml: qtp gkc
fng: rcb jlb njt
plq: dbs
dmd: ksd
kxv: cxz ggg ccx zrr
hgr: mvk nph vlz
xqn: stl
snv: gfd nlk qhn vtk
qcg: kcc nzq
mtd: trl gmv fjr gfk
jxd: llm
shr: sjv xfv
fct: lzv stk qll
zzg: ngn qdj
fvr: rxs
xxb: zqm
jlb: stt
lkb: vpt mqk kxp
vfg: tjm pgh
lpb: hst
kvz: rlv
ztq: hpn lmx pfg vnd ccz
ckr: snk rzr mcj
fqz: ksd dbs fzh
lkf: smm
qcz: rlm
mgr: snx
xjs: ghl qxv qhq lbq
mpf: fsn chk szg lfh
gpq: hdl jcj vvq xjp tvf
zkf: mdp
zxb: qff cjb lxs
brq: vtg mzx
gzt: gkx dxn
dps: tqm hlf gqr
lpr: vfb jql
qgl: mkd sxm
hsl: bdn dlc
nzf: hlv
jfx: mdl jtt
chk: ktq ggb
frd: rxs fbm lxs
nzc: pnl llg rln
nhv: lkf njf dbr
mdz: bfj rzs hsl kvt
tfx: qdf xhk msg rlm qvz
fzz: lbv gmj vlk csc krt
brn: gbp hlv cqf
vtz: qtp xbt nvn
xph: shd zjc nxr
jlj: xnf xgp hgj
dmg: fxd tgh mjh llq
tzv: xbk kvn dfg mgd
nlg: vjn fmv bdl
mnt: vnq ggs fsc mjt
fxj: ljv gbh fbh shd
dfz: ckt
trl: cml cvz
nvl: dgl hjx tqh fbm
rpx: pqf mxl ttz
nnn: tkd bbh mkn
hjk: pmd lmx qtp kmd jnn
rlz: hrt qlr
lpg: bps hqv
jqh: hdh tqm
qbc: bfc pkv fct rrm xqj
pzj: njf lkf txr rsv
grm: psl kgz
sjh: ctm stt
mqk: lsx lbk
qzz: jlp sff njt
cnq: lxn tbz hcf flc pkv mvh xxn
smf: tzg
rrj: jzs mft
hfp: hfs ptl fbh ptx
cgn: hdh vpt ngh shv
dhr: cqq zpb lrv vhk
sdl: jcz pvt
rcs: jtr qfk
rlt: pbn dfm nnk hnk
xpm: dlv kgp
hvq: vcq bvb szx zxz tjz
fjs: jtr nlq kbr sjn
qgs: tcg sgm phr
qbp: fhh
fnz: fxr phj tld
bsz: gfr gzb skc hhn
nlq: njf nds
ghl: kvg vvm
nlk: djc sgl bqn
mfs: txj qjd ktx vtx
vfd: ktq gqk kzx
vpt: trt czs
nfl: clg qmx hbf hdp
qtk: jvf bsm vzr ncx plv
xfl: fkf fcr fqz qhm
vxm: xtm
bbh: fdr nds
vpl: ckt zxr qsv gjk rjr
khh: qmn qfk
cxb: rbm
ptl: dcc vtx cft
xpx: lqr
xmt: tpx tpt
qsp: gqx qlz
fgd: bjl zrr vfn
pqd: hqg bxs
gzf: fcv mbf jxd cpb
ktx: qnp cmd
lld: tbz
bdd: jdj gqr
xsn: hmn
cqc: qsc nmh vxt klk
hrl: vvh lzv
xtm: mtk
fmj: xlb qbp
zsh: szq jlc bfs
vsd: txl cmm
nkk: szp xrx kxp
tgh: ngn flh
bfk: ccv khs
bpl: vfg pnl fgn kkj
bcg: zqx zkf tld
kjq: gvz vlp rnc fsc
qmx: xjr bxs
bbz: bnv bdx
fsc: nds gmj
qgf: gfd gtl jvs llg jjz
vff: mgr cvt ssv
bps: cgj
lck: fnl
hrr: qcm tcg cqq
kgc: nnx qvl zjj pqr
xbp: zmt
ttx: lrp
tzg: slt rlv
pcl: mkd gkx
lnn: zxj kvg xhk
bzl: gsv kmk qdf
zxn: qff nnq
rqv: qxj lgn dcr
hhk: prl flh ccx
qmd: ngh sjf cnb
qzg: sdz
cqf: hbf
bzm: jrb hqv
dhg: drl dmg fdr
jtc: lpg
pck: qcc hsx dpz nqh dnt
znk: bsf fxd mmr jkb
jnp: pnl vfg kgs shv vmt hrh
llb: bvb plq
hhb: hlv mnx pvq vlv bjp
nhg: fvb
xkk: sdz
hzf: fcv
cpz: zln bfj
fjc: fqz mvk
csg: bzc lmx dls mtk
lbx: mxl rql gkc bdn
nqx: szz bzc snt vvl snx mfc
hsf: ggq kmd
jcz: hbp
qjc: ksl xqn
xjl: kzx fvm
nfc: hlf dfk xmf qsr
kdl: nfh jqn zkv tpj
hrs: vmt smf zvb hgj
pxl: xsq
pbm: svm gkb xtb gjd
kvt: xxd ggs
nkc: bdk zmt qcz
zzp: sln cmd tvg
rcv: cpr plj fkx cqq
sjs: ffq bps
psg: xrd mjr vvn
qtt: bnv bqf qxj smm
bgd: btb tsm xrb
gxd: tcg
tgr: kvp
chp: dpl xbp
gzp: kgp bps pdq nmd
fps: lbq
ccj: khs qnp
ftt: tfj hdj sxm zzg cql
rzz: vbr
dhl: dlg
vkv: mcj
vxq: qrj xmg rkx qjg
pch: dlt fkx qvl ztn
lpf: msg rlc jfr
rrh: bqf rpg
bcx: rnx pzm jlb rzz
lrh: qbz
jmk: ftz rqg hzn
jnq: nmh mgb hzn
lzt: ttc
txr: hgr
vxt: nnq
mcg: bvb ctm
hxs: xjp dmv
pqt: vlv vtk
vns: pxl jqh bzl rgb xph gfd
hnk: rkb
tkq: lck
lbq: hph lgk
hqh: nxx vfq fjp
mjq: cvf sjs ljm
rtt: vpc rgx bqv bvv
ncx: cqq
lvh: mpb qhh chq nzf
pnj: gjd sql cgx sls
ffk: tbc rzp srg rrm
rxx: hzf hpj cgx fnf fng
kkl: kkq fqz
vbq: mzf nvr
rkb: xmf
pvg: qmn
dsz: ffx kgp hmq xxb
xml: cql qfk lld
kbd: lkf pcl vdj
bvk: qcg nvg cpf vlr
ggb: kqn tph
fkp: dgl mdl nfc
gzz: jsg mjh
mjh: tbz jkb
tgn: qnp cnb
bbb: kmd mdp cxb
xzb: xsr bkl tdq
phq: hlm dqp kdj
cxp: hpn nbg vrx dqp
ztc: hqh ndd vqg nkt
vbt: bcg skc vxm nnm
bqn: ttc gqr
ttt: kdz ccq txr fnf hcc
kls: kkm
bvb: hcf
dlv: xhm lbk
hnl: chp nhg tch
bgr: bfk
xfs: qcx qzg
rsb: szx gcn qgn kbr
nlx: xhm qdf
tdj: dnj xrx jgh frd
qhj: rpq xpf ghz
xhm: vxt
rrn: qmv cqz tjm
bhn: kff tch
vjs: ttc npb ttx
nmd: pvt djc vzz
hfn: bdl njt tbt tbl
cjb: tpk nnc
mbf: gmj
hlr: jpk kls hhk
jjg: vpk lld vbq
bnt: lkv mlp zst rhx
fqq: zmt vxt vhr
zfh: rbn rzs gvz bbm
mxl: xgd
qhg: xfp qll
cmf: rpl
smb: xsn dfm
trb: smf nrn
glk: xts xpx vbr szz
kzj: lcf
srg: mgr
fgs: tkr qlr thd vlh
zjc: cjz jqv
zrz: hnk kkj tgr trl mgd vkv
xxf: jlb ssg bdl lkv gqx
szf: hhx cvq
kzq: nld nxv pqd dfg
bzc: zkn
cjr: vpc
snt: lcb qfx klz rcb sml
ztf: khh fgd
gmb: jdq mgg rjr
ngh: hmn
blx: sht nxh xmf
bpk: zkn bdx
htq: cvq sdf xtb
hpn: rgm bnv nlq
dkl: fzn hdh lkb
kmk: jzx lvk dfk bkl
tch: qpm
gqd: pmx hdp
vzz: klk
tbc: lbv nnn rhx
cxz: fxr
kdj: qcx
bck: mgd
nvg: nnx jgh
jjd: dmv bbh mkd sxm vhc
gkb: qzg bjl
npz: vtf ndd kqn
lkv: rql kzj
vvd: jql ljs ldn
gbp: dpl
xfh: kks qcx klz rsv
fpf: rsp ksl gdm ttz vrt
rlq: jst zjv jkf sbh
bsn: cgj lck xpm
xcm: xtb rlb rcs
gpb: vtv
hxm: dht tdq bqm hdk
rbn: kkm xrr
zmf: xbt zzg
rtx: rkx vfq rlz hrm
xdx: vtf rnl
bkl: xgp hlf
rxq: vff mnt dmv hrj
zgm: vxm vlk
tdc: vjn rbm dlc
rxh: xks kdj
hlg: njz fdf zgd xdt gcn
sjn: sdz
skc: hcd
nvn: jst slc lcf ncf
crl: dlc
bdx: grj
mbp: ggg vrx fdc zpp
bfj: nsf hxs
jlp: dds zkf
fvc: xks grz mdp
nst: dfg
jdq: nmf dzt ccv
qgh: xcf hdr rkh hfp
vrs: dgl
kpg: ljf kcc
blj: dmv mjt sbh pkd plq
jrb: zld hmq shv lxs jbq
ghc: txr pns nbg dbs
jpk: xlb zkt
gsg: tkq trb rrs slk
kpf: vzz psl
rsg: ntb
zms: kvp qvz dlm cnb
bgp: bpb grj crl hqx
fdf: mjt
xzc: cmd fmq bcm dps
dgt: mvh
fmq: zlg
hlt: zsr xmg
drv: qsr lbk vlr
pns: ctf csc kgh
ggq: zkn tbl xrr
stk: zrj
pfc: zxf tvr ztf gzb
dhp: ssg bjt
hlm: vlp
xsp: sjv phr tgr xlp
nrn: ljv nnk jbc
lxt: lqr mpg kdz
jdv: fvr nnx zgs vfd
tqb: nkc fmq jvr cpk
gzq: jtt mpd cht
bhv: jcj
jzq: rjj ttj lgm lxn nxp
tkr: pbn djm hlt
tdl: xks kpt zkn qsp
xzv: kgk ggb nqt
jdg: cml rlz nhg jzx
dfk: jfr
jst: tlb
dzv: mfk pcl xxr rgm
rxg: nkt scq bsj msg
bsc: djc fbm
pgh: gqd
tjm: zmt tlk
cdl: dmd xrc
pml: svp kqc
brb: tcq tsv pgj tvf
bjp: fvp tvg
fnm: qjc tbl qgl gqg
bjt: njf gqx
jrf: dlg bdd qxv
tbl: kbr
kkj: zdb xsn
mhm: gkp qmx kvz djm
tds: qhj ztk
tjz: xcr
rql: kgh fdr
pvq: mjq nst rlv vqk thd
xgz: pzv jnn vqn
pgq: bbn tpk
bmj: xsq
sml: zpj
kqc: mnx nmh hjb
dcr: zzg kgb
bpb: hpc gjd fsc pvk
bvv: gbh
jsg: jjk krz cmx
gsj: pdq bqm nnc vjj nfh
cgx: xkv gmj
tbt: pqf bdn
cdq: vvn nld dpz jlj xjs snd drm xmf
scr: dpz gtn sjv
fqc: pmx zng nsr rvr jql xlp
sxm: stl
vtj: drm xjr fvr
vrq: dds zsh csc rzz
fhh: cmx
nxp: cxz tjz svk lcb dzq fhh
pbx: fvj sgl jbq rrj npm
pld: gxq zmm gjd bvd
vvh: dls lbf
hdj: sxm vpq
rxs: cjr crr
hrx: rsv njz qgn pdf
ltr: pvg gcb lcb
lsx: xxc qhj
jlc: vjn
pkv: tcq
xvr: zkt bdx
vjj: xbp bgr
npm: zvb rzb jrn
slk: pbv dql fgr kgs gjp
rxd: fpl lqg
zpp: ctf phj
ljs: tgn
vcq: qml lvb kmd rbn lxb
mqx: zng txj zxb jnq vfs
zxz: hcd hkr hpj
ffn: qlp
smr: pdf hmz
tct: rkb zvb jkx vfq
rcq: zsr lbk ffn
rvs: cqq fsq nzt
qfh: sgm cnb
bzt: gxq kks krz pmg
sxh: sdl rvr zsp bhn rrs
zpl: qsc fvp hqv vhr
vmt: jdj zxj ckt
qxt: llb rrk gqx
mxz: jcj cnx xhz fvc
fsz: fgn vzr sps nnk nfl
tzj: jbq nzt npz dvl jqh
dcj: zld ljf
cql: zhb
fgm: brc sch psg
fdc: prl cxt qjv rxh
ssj: lfv gqd sjk tch
xnl: xzv fjl lzt ddj
hdm: szp
hxg: jgb rgk drl tsm
rtj: tmx hst rnd jjz qlc hph
vjn: njz
rlb: cvq xks grj kgh
zvr: hrv qbx jnk pgz
dlx: bgn nsf fnz gcb
rmv: qsr bsn gbp lxs
prt: nbz lmm jzx
nnm: qdz pmd zkf xgd
xxr: slc bvn
lnq: tfx svt bjp jtc hdp
cqz: fbm xrd
khz: xfp sff sjz crk
gvc: ljk frv xrh lbf
qkd: kgk xbp gmv hsq
fbr: pgz gls tfj
bbs: brn qjg vqg mhp xgn
src: kgh
dlt: cqf qpm vfs hmn fzn
qct: tbq ctm qdj xcr
ldc: fdf hpc mzf
mjd: tfh nzl lhn sql
sbm: ktx qff kvz qbq
qcm: kff gsv
nkd: mjz snc cpr
gqg: vsc
ntn: ksd hpj fcv
rdh: xsx bbb rnc mvh
zbc: kgs
mfc: qdj xqj vlp
fdl: llm qlz gdm hvz xrh
mlp: qjv frv zln
lxb: dcl bfk rrj hjb
czs: bqv
vrt: ssd
fsq: nkd snc
rdf: mzj szj tgt phq fnf
llq: pmg zln mpg gpb
lnl: ggm hrt lfl rvs rkh cvl
xjr: npb
qsc: fnl
plv: chq
dlm: llg vtk
mpd: bps
mxn: gbb fcr qml kkl
qhn: cbc qdg ffq
ptx: vhr
ngf: qvz tlx lqg
rnl: ktq rgx vzr qbz
vtk: dtg
mgg: dnt cnb kgk vtx
cxt: vrx xfp
tfh: xfs zgf
fsj: tlk mjz cfb zqz
ntb: vzr vvm
zgd: qrz cvq
kgz: dnj xjr cjz
pkh: bck hfj vqh
nzt: kcc slb
vbr: fxr
rcp: hdh tjm sbm rlv
pmg: rnr
mpj: fxd zpp vlf zjm
msm: zlm lkb
sns: lqr llb hpc npr
jxb: xnf mvt qnp
mrq: gfr plq
qgn: nvn
szz: vsd txn
ltq: xpf
jbc: ttx xjl
ckh: tfj kdz rcs
njf: gpb
mkn: jst kmq kgb
ttj: mgq bgn rrk
nlh: xmq zjc psr cpk
kpb: svk vpq ssv gzz xjp
dfg: ctk vjj
dcg: vrt kmq hvq mpg crk
tvf: nns
lrv: slb jkx ldn zlm ptl
ggg: tpx gkj
hrh: bsc dhx ghz
pmj: tfj
tqm: nxx
zrr: gpb zqx
kzx: rnd hst
dbs: snx
pqr: cjr hrr hvd bsn
nnk: ljv cvl nxr
hkr: vvh trd flz qtp cmf
qsv: xhm xrz
mxs: fps dpn qcc pkt
zgf: tvb rmk
ggm: trt
hfj: vtb sdl cpk
dtl: jlf mhz mzx fvf svd
sbb: ftz xsn mmr
mgb: rsg xhk pgh
xlv: jgh smb lfd hqv
rhx: hlm rcb gqg
ccd: lcf xhn fnz tlb dxn smr
psr: nnq rnd
nxr: xbk
qcc: xsn htg
dfm: vrs
blc: lbf vsd slc csg zcp bvn
xgm: gcb lqr ntn mdz
dmr: mxl llt lld
fpl: svt
tpj: vqk nkk chk rln
grz: kdj nlg jcj
hhn: ckh rxh skc
mss: rrh svk pqh
fdp: rnc
szx: ccq sbf
gtx: djm
jzs: ljm bbn hxm
hrj: zhb vnd ssv hsl
pbv: sln pqd rnn
qhh: ntb ffq
tmq: cpr zpb jqn mgg qlr
jrc: rmk tbz dls bqf
mzf: fqj
mmd: dlh trt
sph: jjk kdz
jmv: mjt tbq sql tdc
xxc: nxr vbd ffn
mdx: vhr mhp bbn tpk
xjp: qbp
bbm: sdz zgf xfl
vcc: kgj xgd csc
xbk: npb
zdl: qzg mkn lgf fmv vnv
plj: qlp klk
hnp: rnx xbt pqh xkk
zqz: hjb dvl nzq pqt
fbh: cbc hdk vrs cqz
zlg: nnq slt
fxd: ncf gmj
nqh: tph
qnv: xqj lbv mtk ngb mnt krt
flc: fmv bvd zrv
npr: zln pqf
vpm: nzf jxb xfv nvg
gbz: hvd nxh plj
kbl: glm shd bcm vjs blx
lvk: kzq vpt pmx
gdg: ggb qjg
pmb: nnq nnc
ddj: xhk hjx lpb
hvd: xrx xmg jbq
svt: ldn
nfh: fmq ctk
gnf: hnl fvp psg cjb
nxh: lrp
pzv: gkj xhn
sff: vvq
tgt: mzf qkc kbr
phj: jsg
ppg: qkd zbc hph sht qdf mnx fkx
dpn: fpl ngh
kcp: mzj cnq lvb kst
svp: jlf
hxn: qcz nxv
ssv: jxd
vnd: fxh lkf
zrj: nxj lvg lkm
tsp: fnl kpf nlk tkb
vfs: clt hdm
ckm: vpc clg xzb
cjc: gkx xrc jhb txr
scq: vtq nnc cpr
czx: hzf ttj hrl kkm
mft: cqz lxx kgp
lfv: hsx tqh
ljv: fvb
dbr: vpx zcp kkm bjt
tpr: ctz kgk bsn fvb
dgh: bdl cxb rbm
crk: lvb xpx
hfs: lgk zbl
qkc: tpt
zbl: kgp srb
nns: mrq hcd
xsx: pjk bcl
rsv: njt szc
skg: pdf jgb dgh fhh
nlf: tdq gbr gzq
bvd: sbh vpx nnt
bmb: shv khs
vpk: tcb dds rmk
pjk: vdj
fdz: hjb xrd hlf ltq
xrd: czs
kvn: sjk xgn
zmd: cmf tbh hmz
rhr: pqf bgn vtv bjl
mjz: qlp
bhc: dlc vqn njf dls
xgd: krz mvk
msl: bvv pxl nqt
rrm: zmf vtn
fxh: fzh dls sdz
khs: jqv
hzn: pmb
crr: mjz vkv
tbh: khh zhb rrk
vzc: bgr rjr zxn rjb
zsp: fmq xsq kgk
ctd: kxr mjr vtj vtb gtn
vnq: nvr nhz ctf
xjx: bsf crj tcq
hcl: mdp xqj
rpg: dlc
fvb: xsn
glf: ghz fvm fjl
gbm: xtm xnq qct
fjv: nhh qsv tmx lrv
dmh: vtn lvg sql tpx
xnf: rqg lrp
ggx: hzn fqb lpf jgh sxh
ctz: rlv qrj mzk
zjm: bkp fjc npr mbf
gxf: nph llm lvb
mdt: ccx cnx flz xqn
pgj: lbp hcc sml
jgq: zsr lpg cml fnl
dgr: tkv fbj zrj cmx
zdb: xmg dht vvm
ztn: bbn pkz sht
zvb: vbd
gkp: nld vlm
szq: pmg
zrv: rnr tbl gxq
llv: mvt qxv pbq vfg
hmz: jhb
prh: gqx tdl fbj
bfc: gkb bhv bzc
xkr: trt
xcf: zbl qrj mcj jlf
jgb: pzv szq jpc zqx rhr bnv
gtl: pkz xjr xgn
mdl: zxn
ddx: xzk dmd xml cvt
djm: rlv
nvm: kmq csc
hrk: tph khs vfb glv rzb fvj
lpl: slb tlk slt fjl chq
xjm: sbf
tvg: rnn jtc
vlz: fdp drn
rzb: dps
zzl: hqg zpl bzm fzn
gbh: ctk ggb
cdh: qlc vjs smf nlx
fvm: ctk xzn
qrm: nlf lbk fnl tff
vvf: mnr tzb sjz vtz
sdf: kks ssd bbz gzt
pdf: fbj
rth: vlf hhn bvd gkj
bsf: gzb kst
mzk: lgk
hdl: bdn drl pjk
rsp: krz flh
vnr: rcb qmn sjh
fjl: xgr mgg
pmd: rpg xcr
rlj: bqn rnn dcc drm
vvq: dqp
vqn: rqv grj
xzm: sps pbv pgv vrs
zlm: ffq xmf
zkt: kgj vnm
tzb: rmk
ngr: hqx flh stk jkb
dcl: dhl glm pxl
mjc: tdl pzm sql qfx vpx
hph: kpg
cpf: nxx
zgs: mhz
fgn: vhr dht hgj
xxk: rkx vtq qbq pkh bps
rzp: vdj pmd zbb cxz
fzh: drn
pjz: pjk xgd qdz
zqm: zbl brq
thd: vhk dcc dnr
gmv: rlc kqn svp
tsv: cdl xpx szf
pkt: sbb rkb vkz smb
hsc: jjg kgj gcb xcx ldc
njn: tjz kkm lqr
jpc: stt lkm
npd: xkv mgr rsp jlp
ssd: lcf
qfk: vfn
lmx: fml nvr zbb
cfb: pml bdk zbc lqg
cnx: vtv
hhx: xvr zrj
mvq: mzk sch
rxv: fmj nds sdf
svm: src kks
frh: ssb mmd gff msm
rpj: nkt npz chq
hmq: vlv gdn
vqm: kvs
dkk: shr jzx ztk xbk
hnt: cpz btb srg
fcp: npd znk bpk jnn jnk
zmm: qbx vgf
qdg: cvf rnl bsm
xgh: trd lxt jxh zgm
qhq: fqb tdq vfd
gjn: ktx snc ljs vbd
xtb: vxm hsl
sjf: xhk brq nqr pkz
ksd: bhv
zjj: nmt rnd msl tkq pgq cvl
lfh: xgn zng cml
bxs: gqk
dzt: khs rnl xkr
rjj: kdz nmq ksl
fnh: nmq dzq smm sls
qlc: ccv bsm kqc
dds: mpg
csv: gvz jxh jtl qfk
gvm: ltr pvk
nnt: tkv qsp qrz
fxx: lfd scr dcc smb ccv
txl: bgn kls lqr
xhz: hcf
njt: hgr
bcm: tcg
sjd: nvm njt tkd tsm
nqr: pbn kvp
fml: mtk
dnp: gqr bck gdn lfv
sls: bqf
pfv: tvf kbr xxz hpj
xsr: lpb nhg dnr
qvz: nmf
nlt: vbr crl blj
nhh: sch xzn
vzp: jjg vbq vlk smr
pkg: kkq flz xxn mdt
mjr: cjz
rpq: qnp rnl
bkp: lkm
rng: jtc zxj mfs ckm
lxn: xtq fqj
tkb: kpg pgq
jnk: tpt fxh
gbb: kdj
fsn: kvp rrn nmh fps
vqg: gtx
llf: dfk kkt xzc
psl: bmj cgj
shn: pbn nnc qbq sjk
mvl: jbc nlx pml dkl
frv: dgx hcl
vqh: szg clt llf
gnz: nxq mcj kgp lxr zqm
bhz: rrk kks
pdq: cfb kvg
djc: tgr hqv
ngz: ckr nxq vtx grm rzr
kxm: dmr pjz jjk
mhc: nbz fsn brn drm
fqj: xxd
rvr: dpn pxl
zqc: nph qcx gvm flz rpx nns
zst: ccq hlm tkv
pqc: cmx sbv svm hrl
xvn: klz pzm vlp
vvn: lxx hmn
zmr: tkd fbr nmq fml
fgr: llg pvt
cht: ggm hlv chp
sln: dlg
rzs: pmj lmx
gjk: dps glm
ggl: prt ngf dgj msm
fkf: fqj qjv lzv
hzz: lfd trb xfv pkz
xzn: hxn
tpt: tkd gkc
drl: qgl zpj
pvl: ftz ndd qfh hqg
msr: lxr hfs mgc kgk
fpv: tjm gff tkb bsm
dht: tlk
sbf: kmq bbz
xrx: nsr
ghr: hrv kzj sbh gxq
hqg: pxl
lvv: qhg gzz fhh xjx
tnk: ngh vtg tlx
tlb: zpj
mgm: kmq hrv hcl
hzs: zpp cmf rbm gls fzh
qff: kvg
fsl: lzt glv
vlr: kkt mgg
ttc: ftz
vsb: kgb vnm tpx lvg
mck: ngn kkm gbm mrq
htg: gqr ktq vzz
xtq: cvt nvn grj kgb
szg: llg dcj
vsc: vtv sbv
szc: qhm cpz xsx
qrz: nds xjm qll
mnr: fjc xvr
zfq: gtx vbd vjs
qdj: xlb
znx: slc phj sff dhg
kbf: kqn xxb qnt sln
gdp: rcp rnl hdm kvn
ffx: bhn lrh
bzg: hmz njf cxt
xpf: cjz vtq
lqg: lgk kxr xmq
pfg: sph zgf
ghb: dgl
cpb: lzv djb vsc fvc vrt
cvz: fsq xzn kzq
jfr: zld bmb mmr
krt: xfh gdm xrb
rzr: clt bfk
rhv: vvd snk tds gkp
rlc: gtn
zxc: zxn rgb qtk fkp
hbp: clt
ghz: vqk
gsv: hbp dfz
qnz: vhc lkf lbp mzj
kjk: sgm mgc lqg ndd shr
ndl: tsv qxt vnr fmv
bsj: ltq
xts: rnc rxv qml
rgb: vfb
kgj: mvh sjn
xhn: vhc rpl
mhf: xrr mcg nlt bgp vlz
mlc: sgl rjb bsj jqv
tld: dds
cbc: xxc qpm mhz
xzk: vvq mbf qjc
kvr: nsr fsl nst nhg
jdj: sgm xnf
dhx: dnt qhj pmb
sjz: bpk dlc nlg
qnt: lfd cmd xrx
xkv: rpl
vtq: dnt jql
xdt: szf bhz rql pmg
qvl: gbz glf
cvq: fnf cmx xrr
lxh: rgx gdg lrp
jjz: gdn
vlm: xmj vlr cgj xzn tlx
prl: vfn dgt
fdh: hdj xbt kkq jlc
xjn: qhm hdj vdj mjh kvs
rzn: llm rnx lcb zjv
jqr: bvv qcm jqv dvl nzf nzt lmg
lxx: xgn ghz dfz
rrc: xpm kxr fvr qbz
zxf: xbt kbd sbv
xvz: fdr cnx vlf qxj
zkn: qxj xlb
txn: lgn lzv xqn tbq
pll: dgt jtr nsf jnn
cvf: xkr
qlr: hbf
gcn: src hhx
zjv: kzj
rnf: qkc xvz dcr dmd
pqh: kmd vqm
fxk: nxh cmd
tmh: snk svp nzt hdk
nck: kls qzz bjl dds
vgf: xvn xmt
jtq: rxs fjv txj jkx
zsr: zmt
spp: qhm vqm hnt mgn
fbm: npb ptx xmq
mpb: xmj glv zxb zbc
ccz: mkn jkf nbg
fbq: qlz xxr kzj ztf
zbb: tcq
szp: bgr glm
gfk: jdq gjk jjz
ndd: lpb
xrz: rgb bqv cpf
dzq: lbp xhz
jrn: bbs fqb txj
qsr: vvm cvh
lhn: vlk xxd bfs
qxv: hlt
nxj: ctf
lxr: sdl nmf
kcx: zxj fxk ljs bmb
mzj: gcb
slx: mhv xgr cmd
mnv: snk mjz
bkt: xmt nvm xkk
ftf: tfj hvz dhp mxr
rjc: dvl ccj bqm ptx
ssg: ngn
ssb: vtf dcj qcg
mvt: tph vtg svt
ljm: rlm ggb dtg
jvs: cpf fsl ffx jbc
lmr: hrt ghb bsj gtn
gbg: pcl ggg bzg dgx
bqk: nbg hhk bhz rlq
cft: mnx jqn sjs fjp
dnk: dgx xxn qhg fzz
dbb: dgl hmn pbq
lcr: rpq mvq hdp vlh
jxt: kcx nzt xbk vlm
cqs: ntb cbd lck tgn
qdz: fdf mvk
xxz: gcb bkp nph
nzl: fcr pvg pzm
dfl: jpk sph hlr qxt
dpz: dlm vmt
bmp: nhh gdn jcz bps bmb
sps: mhp
xxq: lkf kxm jjk zcp szq
pgz: nvr
qqj: fgm fps fqq hrh
bdk: qlp
vtb: vtg qpm
hrt: klk
kgh: bcl
bxh: jnq tzg bxs rlc
rnx: ddj
ngb: sls pjz sql
lsg: snx dls ttz tfh mss
bfs: gkj tvb
pgc: tbt drn dmr cpb
dql: zlg fzn bck
spd: fzh cxb kbr jkb tcb
rln: hqv rjb
lbp: zpj
znn: hgp qjv trd dxn
cvl: sht
tff: lrh dnr hrm tnk mmd
lgf: khh lmx
hpd: fdf gxf ksx vcc qll hsf
xrh: lgf xkk
snd: gtl rxd ljm dbb cvh
gvz: rgm hrv
jhb: fdp lcb
bvn: ncf tbt
kkt: fjp
lgn: sjn bjt
xgp: kcc sch
qfx: stl ctm
fxm: dmh pvg szj tgh
qnp: xsq
jvf: bsm mnv gff
fjr: dlg rsg glm vkz
hlv: bsj snk
kqb: jcz nxx kff nmd
rkh: hbf smf
ctk: rlv
zqx: rrh qhm
kbj: stk rpx hcd fml
fvf: xph fgr jtc hjx
zpb: mqk hjx pnl
srh: xgz njn vhc hqx
cpk: bbs lpr zzp
rjb: lrp
rnh: slx qbz ttx xfv
lgm: bgd tfj pvk
rjm: rsg bsc jmk vfq kvz
nsf: ccx
pvt: qbq
sgt: hcc hsf zmm sjh vfn
zkv: dfm bzm gxd clt
znb: dmh nhz crl pkd
cmh: vmt gmb ghb tkq
dtg: nxq
xck: zgd klz rpl tlb
hdz: xlp gmb bdd nld
gls: mzf
jtl: gfr dhp xjm kkq
nhz: xqn
hgp: vtn tzb sls
fkx: nxq
vkp: fdf vvl cmx svk
shg: hsq mpd nkk
mgz: rnl mvq jfx qgs
vpx: gfr
vnv: zmf pmj jpc
pnb: ctd psr fkp plv dhl
rjr: mzx
xrb: tbq nvr
qrj: rkb
qjd: hgj vlh lpb
sfg: fxk ccj cjr dtg
mhv: lpr srb vhk
njz: hqx
jvr: pmx slk mzk ntb
jxh: rgm
hdr: ckt vqg xdx ddj cqf psr
ljk: mnr tjz vgf
kff: rlm rsg glv
vlv: hdk xkr
zlb: tsp rgx qkv rxd hst
tbq: fcv zjv
tqh: qcz slt
dlg: bmj
trd: qbx
xxn: bdl
kkr: clt nzc dlv nqh
qqt: lbf ssg kvt szc
zxr: zfq gxd cfb
kxr: vzr
pgb: gbb lbp gqg qxj
hvn: sps nxv dhl ghl nst
gdf: gkj xfs szf qbc
nmt: xjl grm
hsx: fnl
qkv: mgd dpl bmb
nqt: slb pgh
tfm: hxn jrf xdx rcv
tmx: rqg vkz
rrs: nnc pbq
tvr: zvr kvs src
ztk: phr hnk
brc: sjv rlc
pvk: fdp
fqb: vxt nmf kcc
bhm: dcr zbb vlf jkf
fvj: lxh dgj clg
mgn: jxd rzz tld xjm
xfp: zln
xrf: xkv lkm vpq bzg njz
szj: nhv mcg
tsg: jcj nxj xcx bhz stl
btb: bdn bcl
ksx: pdf qkc svm
nbz: tzj tmx gqk
kgs: rgx
jtt: jqn gtl
lbv: vqm djb ctf
xcx: smm ncf
sgc: zld lfd xgr cvf dnr
hkg: xjn vnr xjp ksl
ljf: hsx mcj pbq sch
tvb: mkd ssd
dnj: mnv dpl lzt
nzq: bmj tqm
lmg: crr nqr bps
zqd: fkf sdf kkl zgm vpq
cbd: zsr gbr sbm ltq
dxn: jlc
cmm: mgm tkv gkx jxh tcq
mhz: fpl
jlf: msg
vvl: rlq rcs
lfl: mgd tds shg
hvz: qgn bbz
kst: lbf
lxs: hsq
hcf: srg ctf nph qmn
dlh: ffn lnn
rmg: vpc pqt bqv xpf
ggs: rnr zcp gls
gbr: kpf gxd
bqf: qbx
qjg: gfd lsx rgx fjp hbp nkt
fbj: bbz
lnb: zgs gtx rzb djh kxp
tsm: xxd jcj dgx
xtv: ffq dvl zms lrh
vnm: hpc fxr
lvb: slc
llt: qlz rpl gzb
gtv: vgf bqk qll hxs
hkb: drn pkd rpg dgt xnq
nnx: phr
cvh: sjv
mgq: xqj rsp vqm
xnq: prl nhz
stt: xfs hcc
mzx: vfb
lvg: jlc rxh xtm
crj: gkc zhb kvs
fzn: kgp
dgj: nxv glv
mfk: xfp qbx pgz
mmr: vkz
bqm: xgr rkx
snk: ldn
gjp: nst bdk ncx
mgc: qmd cvh drv zgs
ccq: zln
qrd: ghb nsr gjn jxb xsr
sgl: gbp fvp pmb
clr: dlh ncx mhp hsq
pgv: nzq xmq lrh
xmj: nkt rgb
clg: dfz qlp
hrm: czs jkx
qmv: rnn jkx vkv
qfz: bkt zxf hxs vtn
djh: vlv mpd srb
nmq: pkv cvt
gff: vqk
xrc: rpg pmj
vrx: jtr
fkj: fmj hpj bdl zmd
tcb: nxj pkd djb bhv
sgz: gzq pbn ggm dpz
ksm: tdq kkt zsp kpg
gtt: ttz pfg rpg gvm
vhk: qcz
pjb: rpj nvq rqg gfk
bqv: vlh
vlk: hzf
xmd: vvh sbv bhz sml
mns: xcm bcl bvb cdl
hdc: fgd gzt frv prh tzb
nvq: qhh gqk plv snc vtf mjr
tlx: bcm qsc
kpt: djb fcr rzp
pbc: jpk kst lsg xfl
svd: ztk nmt srb brc
sjk: hqv xlp tpk
rgk: tvb vlp rnr
jkf: qbp
zlv: gdg rcq kxp rkh qfh mdl
shd: xhk pbq nqh
gcr: xxb qlp jfx kpf""".split("\n")