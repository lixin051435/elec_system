(deftemplate eleinfo
   (slot ifa)
   (slot ifb)
   (slot ifc)
   (slot ifab)
   (slot ifbc)
   (slot ifac))
 
; a单相接地短路  
(defrule a_di_duanlu
(eleinfo  (ifa ?ifa&:(not (= ?ifa 0)))(ifb ?ifb&:(= 0 ?ifb))(ifc ?ifc&:(= 0 ?ifc)))
=>
(open "res.txt" res "w")
(printout res "1")
(close res))

; b单相接地短路  
(defrule b_di_duanlu
(eleinfo  (ifa ?ifa&:(= ?ifa 0))(ifb ?ifb&:(not(= 0 ?ifb)))(ifc ?ifc&:(= 0 ?ifc)))
=>
(open "res.txt" res "w")
(printout res "2")
(close res))

; c单相接地短路  
(defrule c_di_duanlu
(eleinfo  (ifc ?ifc&:(not(= ?ifc 0)))(ifb ?ifb&:(= 0 ?ifb))(ifa ?ifa&:(= 0 ?ifa)))
=>
(open "res.txt" res "w")
(printout res "3")
(close res))

; abc三相接地短路  
(defrule abc_di_duanlu
(eleinfo  (ifa ?ifa&:(not(= ?ifa 0)))(ifb ?ifb&:(not(= 0 ?ifb)))(ifc ?ifc&:(not(= 0 ?ifc))))
=>
(open "res.txt" res "w")
(printout res "4")
(close res))

; ab相间短路  
(defrule ab_duanlu
(eleinfo  (ifa ?ifa&:(not(= ?ifa 0)))(ifb ?ifb&:(not(= 0 ?ifb)))(ifc ?ifc&:(= 0 ?ifc))(ifab ?ifab&:(= 0 ?ifab)))
=>
(open "res.txt" res "w")
(printout res "5")
(close res))

; ac相间短路  
(defrule ac_duanlu
(eleinfo  (ifa ?ifa&:(not(= ?ifa 0)))(ifb ?ifb&:(= 0 ?ifb))(ifc ?ifc&:(not(= 0 ?ifc)))(ifac ?ifac&:(= 0 ?ifac)))
=>
(open "res.txt" res "w")
(printout res "6")
(close res))

; bc相间短路  
(defrule bc_duanlu
(eleinfo  (ifa ?ifa&:(= ?ifa 0))(ifb ?ifb&:(not(= 0 ?ifb)))(ifc ?ifc&:(not(= 0 ?ifc)))(ifbc ?ifbc&:(= 0 ?ifbc)))
=>
(open "res.txt" res "w")
(printout res "7")
(close res))

; ab接地短路  
(defrule ab_di_duanlu
(eleinfo  (ifa ?ifa&:(not(= ?ifa 0)))(ifb ?ifb&:(not(= 0 ?ifb)))(ifc ?ifc&:(= 0 ?ifc))(ifab ?ifab&:(not(= 0 ?ifab))))
=>
(open "res.txt" res "w")
(printout res "8")
(close res))

; bc接地短路  
(defrule bc_di_duanlu
(eleinfo  (ifa ?ifa&:(= ?ifa 0))(ifb ?ifb&:(not(= 0 ?ifb)))(ifc ?ifc&:(not(= 0 ?ifc)))(ifbc ?ifbc&:(not(= 0 ?ifbc))))
=>
(open "res.txt" res "w")
(printout res "9")
(close res))

; ac接地短路  
(defrule ac_di_duanlu
(eleinfo  (ifa ?ifa&:(not(= ?ifa 0)))(ifb ?ifb&:(= 0 ?ifb))(ifc ?ifc&:(not(= 0 ?ifc)))(ifac ?ifac&:(not(= 0 ?ifac))))
=>
(open "res.txt" res "w")
(printout res "10")
(close res))