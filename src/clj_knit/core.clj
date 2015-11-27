(ns clj-knit.core
  (:gen-class))

(defn do> [iv & fns]
  (cond
    (empty? fns) iv
    :else (recur ((first fns) iv)
                 (rest fns))))

(defmacro +> [f & args]
  `(fn [x#]
     (~f x# ~@args)))

(defmacro +>> [f & args]
  `(fn [x#]
     (~f ~@args x#)))

(defn -main []
  (print (do> [1 2 3 4]
              (+>> map inc)
              (+>> reduce +)
              (+> + 5))))