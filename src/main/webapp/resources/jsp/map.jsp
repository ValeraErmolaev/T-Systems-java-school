<%--
  Created by IntelliJ IDEA.
  User: vermolae
  Date: 12.01.2021
  Time: 19:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>World Map</title>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <link href="<spring:url value='/resources/css/header.css'/>" rel="stylesheet">
    <link href="<spring:url value='/resources/css/jqvmap.css'/>" rel="stylesheet">
    <link href="/resources/css/jqvmap.css" media="screen" rel="stylesheet" type="text/css"/>
    <%--    <script type="text/javascript" src='/resources/js/header.js'></script>--%>

    <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script type="text/javascript" src="/resources/js/map/jquery.vmap.js"></script>
    <script type="text/javascript" src="/resources/js/map/jquery.vmap.world.js" charset="utf-8"></script>
    <script type="text/javascript" src="/resources/js/map/jquery.vmap.sampledata.js"></script>
    <script type="text/javascript" src='/resources/js/header.js'></script>
    <script>
        jQuery(document).ready(function () {
            jQuery('#vmap').vectorMap({
                map: 'world_en',
                backgroundColor: '#ebf0f1',
                color: '#ffffff',
                hoverOpacity: 0.7,
                selectedColor: '#666666',
                enableZoom: true,
                showTooltip: true,
                scaleColors: ['#e8edef', '#3b7002'],
                values: sample_data,
                normalizeFunction: 'polynomial'

            });
            jQuery('#vmap').vectorMap('set', 'colors', {ca: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {ru: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {us: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {mx: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {br: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {dm: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {is: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {ie: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {gb: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {se: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {fi: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {lv: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {pl: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {by: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {it: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {fr: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {nl: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {be: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {de: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {ch: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {cz: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {sk: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {at: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {si: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {hr: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {dk: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {lt: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {ua: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {ro: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {rs: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {bg: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {al: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {mk: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {gr: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {ee: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {md: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {ba: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {hu: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {no: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {pt: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {es: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {eg: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {kr: '#76b852'});
            jQuery('#vmap').vectorMap('set', 'colors', {pg: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {dz: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ma: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {mr: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {sn: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {gm: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {gw: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {gn: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {sl: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {lr: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ci: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ml: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {bf: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ne: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {gh: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {tg: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {bj: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ng: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {tn: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ly: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {td: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {sd: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {cm: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {er: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {dj: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {et: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {so: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ye: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {cf: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {st: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {gq: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ga: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {cg: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ao: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {cd: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {rw: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {bi: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ug: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ke: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {tz: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {zm: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {mw: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {zw: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {na: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {bw: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {sz: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ls: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {za: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {gl: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {au: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {nz: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {nc: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {my: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {bn: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {tl: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {sb: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {vu: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {fj: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ph: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {cn: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {tw: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {jp: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {mu: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {re: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {mg: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {km: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {sc: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {mv: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {es: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {al: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {in: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {cv: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {kn: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ag: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {lc: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {bb: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {gd: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {tt: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {do: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ht: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {fk: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {lk: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {cu: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {bs: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {jm: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ec: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {gt: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {hn: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {sv: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ni: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {cr: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {pa: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {co: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ve: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {gy: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {sr: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {gf: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {pe: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {bo: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {py: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {uy: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ar: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {cl: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {le: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {bz: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {mn: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {kp: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {kz: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {tm: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {uz: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {tj: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {kg: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {af: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {pk: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {in: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {np: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {bt: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {bd: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {mm: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {th: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {kh: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {la: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {vn: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ge: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {am: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {az: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ir: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {tr: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {om: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ae: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {qa: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {kw: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {sa: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {sy: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {iq: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {jo: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {lb: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {il: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {cy: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {mt: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {ta: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {id: '#515150'});
            jQuery('#vmap').vectorMap('set', 'colors', {mz: '#515150'});
        });
    </script>
<%--    <script>--%>
<%--         jQuery('#vmap').vectorMap('set', 'colors', {us: '#0000ff'});--%>
<%--    </script>--%>
</head>
<body>
<header>
    <h1>eCare</h1>
    <nav>
        <a href="/">Home</a>
        <a href="/account">My account</a>
        <a href="">About</a>
        <a href="/tariff">Tariffs</a>
        <a href="/map">Map</a>
    </nav>
</header>
<%--<div class="wrapper">--%>
<h2 align="center">Coverage map</h2>
<div>
    <div id="vmap"
         style="width: 75%; height: 400px; margin: 0px auto; position: relative; overflow: hidden; background-color: rgb(255, 255, 255);">

    </div>
</div>
    <div class="wrapper">
         <section id='steezy'>
            <%--        <h2> This is some steezy stuff</h2>--%>
<%--             <span>Test</span>--%>
            <p>Egypt France French Guiana Germany Gibraltar Greece Guadeloupe Hong Kong Hungary Iceland Ireland</p>
            <p> Israel Italy Latvia Liechtenstein Lithuania Luxembourg Malta Martinique Mexico Monaco Netherlands</p>
            <p>Norway Poland Portugal Puerto Rico Russia Singapore Slovakia South Korea Spain Sweden Switzerland</p>
            <p>United Kingdom United States of America United States Virgin Islands</p>
         </section>
    <div>


    </div>
    <%--</div>--%>
    <%--<div id="vmap" style=""; height: 400px;"></div>--%>
</body>
</html>
