$wnd.showcase.runAsyncCallback15("function Au(){}\nfunction Iu(){}\nfunction cv(){}\nfunction fi(a,b){Uh(b,a)}\nfunction zu(a,b){FCb(b.a,a)}\nfunction Hu(a,b){GCb(b.a,a)}\nfunction bv(a,b){HCb(b.a,a)}\nfunction zfb(a){this.a=a}\nfunction Efb(a){this.a=a}\nfunction WCb(a){this.a=a}\nfunction jDb(a){this.a=a}\nfunction FCb(a,b){KCb(a,Nt(b),Ot(b))}\nfunction GCb(a,b){LCb(a,Nt(b),Ot(b))}\nfunction HCb(a,b){var c;MCb((c=a,Nt(b),Ot(b),c))}\nfunction MCb(a){a.f=false;rwb((lwb(),a.hb))}\nfunction OCb(){PCb.call(this,new iDb)}\nfunction yu(){yu=SX;xu=new $t(Mac,new Au)}\nfunction Gu(){Gu=SX;Fu=new $t('mousemove',new Iu)}\nfunction av(){av=SX;_u=new $t('mouseup',new cv)}\nfunction NCb(a){!a.g&&(a.g=ixb(new WCb(a)));Li(a)}\nfunction ICb(a,b){if(a.g){jWb(a.g.a);a.g=null}zi(a,b)}\nfunction KCb(a,b,c){lwb();if(!kwb){a.f=true;twb(a.hb);a.d=b;a.e=c}}\nfunction Azb(a,b,c){var d;d=yzb(a,b);!!d&&((lwb(),d)[mbc]=c.a,undefined)}\nfunction yCb(a,b){var c,d;d=(lwb(),Qxb(a.b,b));c=(null,Qxb(d,1));return null,Uo(c)}\nfunction JCb(a,b){var c;c=b.target;if(Ro(c)){return lp(Wo((lwb(),yCb(a.j,0))),c)}return false}\nfunction iDb(){ZCb();fDb.call(this);(lwb(),this.hb).className='Caption'}\nfunction Nt(a){var b,c;c=a.b;if(c){return b=a.a,((b.clientX||0)|0)-dp(c)+hp(c)+($wnd.pageXOffset|0)}return (a.a.clientX||0)|0}\nfunction Ot(a){var b,c;c=a.b;if(c){return b=a.a,((b.clientY||0)|0)-(fp(c)+$wnd.pageYOffset|0)+((c.scrollTop||0)|0)+($wnd.pageYOffset|0)}return (a.a.clientY||0)|0}\nfunction LCb(a,b,c){var d,e;if(a.f){d=b+dp((lwb(),a.hb));e=c+(fp(a.hb)+$wnd.pageYOffset|0);if(d<a.b||d>=a.i||e<a.c){return}Hi(a,d-a.d,e-a.e)}}\nfunction Gi(a){a.A=true;if(!a.s){a.s=$doc.createElement($7b);Mo(a.s,a.u);a.s.style[d9b]=(Mr(),e9b);a.s.style[g9b]=(ws(),h9b);a.s.style[i9b]=h9b}}\nfunction PCb(a){var b,c;_Bb.call(this,false,true,z7b);Sh(a);this.a=a;c=(lwb(),yCb(this.j,0));yo(c,swb(fh(this.a)));fi(this,this.a);Wo((null,Uo(this.hb))).className='gwt-DialogBox';this.i=op($doc);this.b=0;this.c=0;b=new jDb(this);Lh(this,b,(yu(),yu(),xu));Lh(this,b,(av(),av(),_u));Lh(this,b,(Gu(),Gu(),Fu));Lh(this,b,(Vu(),Vu(),Uu));Lh(this,b,(Ou(),Ou(),Nu))}\nfunction wfb(){var a,b,c,d,e,f,g,h,i,j,k;a=(g=new OCb,fQb((lwb(),g.hb),'',fdc),ih(g.a,'cwDialogBox-caption'),fQb(yCb(g.j,1),fdc,Jcc),$Cb(g.a,'Sample DialogBox'),h=new wQb,h.e[Abc]=4,ki(g.j,h),Ai(g),i=new hDb('This is an example of a standard dialog box component.'),tQb(h,i),Azb(h,i,(oGb(),iGb)),j=new xvb((Z_(),P_)),tQb(h,j),Azb(h,j,iGb),k=new xzb('Close',new Efb(g)),tQb(h,k),vz(),Azb(h,k,nGb),g);Gi(a);a.w=true;e=new xzb('Show Dialog Box',new zfb(a));d=new hDb('<br><br><br>This list box demonstrates that you can drag the popup over it. This obscure corner case renders incorrectly for many other libraries.');c=new PHb;c.hb.size=1;for(b=10;b>0;b--){LHb(c,'item '+b,'item '+b,-1)}f=new wQb;f.e[Abc]=8;tQb(f,e);tQb(f,d);tQb(f,c);return f}\nvar fdc='cwDialogBox';RX(1060,1148,{},Au);_.Pc=function Bu(a){zu(this,jC(a,1175))};_.Qc=function Du(){return xu};_.Rc=function Eu(){return xu};_.Tc=function Cu(){return xu};var xu;var jH=YWb(C8b,'MouseDownEvent',1060);RX(1062,1148,{},Iu);_.Pc=function Ju(a){Hu(this,jC(a,1177))};_.Qc=function Lu(){return Fu};_.Rc=function Mu(){return Fu};_.Tc=function Ku(){return Fu};var Fu;var lH=YWb(C8b,'MouseMoveEvent',1062);RX(1061,1148,{},cv);_.Pc=function dv(a){bv(this,jC(a,1176))};_.Qc=function fv(){return _u};_.Rc=function gv(){return _u};_.Tc=function ev(){return _u};var _u;var oH=YWb(C8b,'MouseUpEvent',1061);RX(434,1,X9b,zfb);_.Wc=function Afb(a){ui(this.a);NCb(this.a)};var vN=YWb(mac,'CwDialogBox/1',434);RX(435,1,eac);_.Ec=function Dfb(){f$(this.a,wfb())};RX(436,1,X9b,Efb);_.Wc=function Ffb(a){ICb(this.a,false)};var xN=YWb(mac,'CwDialogBox/3',436);RX(218,169,edc,OCb);_.Wb=function QCb(){try{Ph(this.j)}finally{Ph(this.a)}};_.Xb=function RCb(){try{Rh(this.j)}finally{Rh(this.a)}};_.kc=function SCb(a){ICb(this,a)};_._b=function TCb(a){switch(lwb(),Exb(a.type)){case 4:case 8:case 64:case 16:case 32:if(!this.f&&!JCb(this,a)){return}}Qh(this,a)};_.lc=function UCb(a){var b;b=a.d;!a.a&&ywb(a.d)==4&&JCb(this,b)&&(b.preventDefault(),undefined);a.c&&false&&(a.a=true)};_.mc=function VCb(){NCb(this)};_.b=0;_.c=0;_.d=0;_.e=0;_.f=false;_.i=0;var hR=YWb(X7b,'DialogBox',218);RX(882,1,zac,WCb);_.bd=function XCb(a){this.a.i=a.a};var eR=YWb(X7b,'DialogBox/1',882);RX(880,30,Y7b,iDb);var fR=YWb(X7b,'DialogBox/CaptionImpl',880);RX(881,1,{1175:1,1177:1,1115:1,1116:1,1176:1,15:1},jDb);_.Zc=function kDb(a){};_.$c=function lDb(a){};var gR=YWb(X7b,'DialogBox/MouseHandler',881);h7b(Fl)(15);\n//# sourceURL=showcase-15.js\n")