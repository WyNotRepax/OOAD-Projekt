$wnd.showcase.runAsyncCallback24("function Geb(a){this.a=a}\nfunction Ieb(a){this.a=a}\nfunction Keb(a){this.a=a}\nfunction Peb(a,b){this.a=a;this.b=b}\nfunction zIb(a){return bxb(),a.hb}\nfunction DIb(a,b){wIb(a,b);jp((bxb(),a.hb),b)}\nfunction Uwb(){var a;if(!Rwb||Xwb()){a=new Y3b;Wwb(a);Rwb=a}return Rwb}\nfunction Xwb(){var a=$doc.cookie;if(a!=Swb){Swb=a;return true}else{return false}}\nfunction jp(b,c){try{b.remove(c)}catch(a){b.removeChild(b.childNodes[c])}}\nfunction Ywb(a){Twb&&(a=encodeURIComponent(a));$doc.cookie=a+'=;expires=Fri, 02-Jan-1970 00:00:00 GMT'}\nfunction Deb(a){var b,c,d,e;if(zIb(a.c).options.length<1){IKb(a.a,'');IKb(a.b,'');return}e=zIb(a.c).selectedIndex;b=AIb(a.c,e);c=(d=Uwb(),ZC(b==null?a_b(o4b(d.d,null)):G4b(d.e,b)));IKb(a.a,b);IKb(a.b,c)}\nfunction Ceb(a,b){var c,d,e,f,g,h,i;fh(a.c).options.length=0;h=0;e=new p0b(Uwb());for(d=(g=e.a.Sg().fc(),new u0b(g));d.a.Nf();){c=(f=VC(d.a.Of(),36),ZC(f.Yg()));vIb(a.c,c);FYb(c,b)&&(h=fh(a.c).options.length-1)}i=h;ym((rm(),qm),new Peb(a,i))}\nfunction Wwb(b){var c=$doc.cookie;if(c&&c!=''){var d=c.split('; ');for(var e=d.length-1;e>=0;--e){var f,g;var h=d[e].indexOf('=');if(h==-1){f=d[e];g=''}else{f=d[e].substring(0,h);g=d[e].substring(h+1)}if(Twb){try{f=decodeURIComponent(f)}catch(a){}try{g=decodeURIComponent(g)}catch(a){}}b.Ug(f,g)}}}\nfunction Beb(a){var b,c,d;c=new EGb(3,3);a.c=new FIb;b=new mAb('\\u5220\\u9664');Eh((bxb(),b.hb),jec,true);ZFb(c,0,0,'<b><b>\\u73B0\\u6709Cookie:<\\/b><\\/b>');aGb(c,0,1,a.c);aGb(c,0,2,b);a.a=new RKb;ZFb(c,1,0,'<b><b>\\u540D\\u79F0\\uFF1A<\\/b><\\/b>');aGb(c,1,1,a.a);a.b=new RKb;d=new mAb('\\u8BBE\\u7F6ECookie');Eh(d.hb,jec,true);ZFb(c,2,0,'<b><b>\\u503C\\uFF1A<\\/b><\\/b>');aGb(c,2,1,a.b);aGb(c,2,2,d);Lh(d,new Geb(a),(Qt(),Qt(),Pt));Lh(a.c,new Ieb(a),(Ht(),Ht(),Gt));Lh(b,new Keb(a),(null,Pt));Ceb(a,null);return c}\nIY(465,1,Nac,Geb);_.Wc=function Heb(a){var b,c,d;c=EKb(this.a.a);d=EKb(this.a.b);b=new LB(eY(kY((new JB).q.getTime()),xfc));if(c.length<1){$wnd.alert('\\u60A8\\u5FC5\\u987B\\u6307\\u5B9ACookie\\u7684\\u540D\\u79F0');return}Zwb(c,d,b);Ceb(this.a,c)};var IN=OXb(bbc,'CwCookies/1',465);IY(466,1,Oac,Ieb);_.Vc=function Jeb(a){Deb(this.a)};var JN=OXb(bbc,'CwCookies/2',466);IY(467,1,Nac,Keb);_.Wc=function Leb(a){var b,c;c=fh(this.a.c).selectedIndex;if(c>-1&&c<fh(this.a.c).options.length){b=AIb(this.a.c,c);Ywb(b);DIb(this.a.c,c);Deb(this.a)}};var KN=OXb(bbc,'CwCookies/3',467);IY(468,1,Xac);_.Ec=function Oeb(){Y$(this.b,Beb(this.a))};IY(469,1,{},Peb);_.Gc=function Qeb(){this.b<fh(this.a.c).options.length&&EIb(this.a.c,this.b);Deb(this.a)};_.b=0;var MN=OXb(bbc,'CwCookies/5',469);var Rwb=null,Swb;Z7b(Fl)(24);\n//# sourceURL=showcase-24.js\n")
